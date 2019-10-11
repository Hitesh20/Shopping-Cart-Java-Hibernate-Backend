package com.caseStudy.eCart.service;


import com.caseStudy.eCart.model.Cart;
import com.caseStudy.eCart.model.Products;
import com.caseStudy.eCart.model.Users;
import com.caseStudy.eCart.repository.CartRepository;
import com.caseStudy.eCart.repository.ProductsRepository;
import com.caseStudy.eCart.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Service
public class CartService {

    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private UsersRepository usersRepository;

    public void addProduct(Long user_id, Long product_id) {

        Products products = productsRepository.findByProductId(product_id);

        Users users = usersRepository.findByUserId(user_id);

        if(cartRepository.findByUsersAndProducts(users, products)!=null) {

            Cart cart = (Cart) cartRepository.findByUsersAndProducts(users, products);
            cart.setQuantity(cart.getQuantity()+1);
            cartRepository.save(cart);
        } else {
            Cart cart = new Cart(products, users, 1);
            cartRepository.save(cart);
        }

        /*return cartRepository.findByUsersAndProducts(users, products);*/
    }


    public void removeProduct(Long userId, Long productId) {
        Products products = productsRepository.findByProductId(productId);
        Users users = usersRepository.findByUserId(userId);
        cartRepository.deleteAllByUsersAndProducts(users, products);
        /*return "removed";*/
    }

    public List<Cart> showUserProducts(Long userId) {
        Users users = usersRepository.findByUserId(userId);
        return cartRepository.findByUsers(users);
    }


    public void subtractProduct(Long userId, Long productId) {

        Products products = productsRepository.findByProductId(productId);

        Users users = usersRepository.findByUserId(userId);

        if(cartRepository.findByUsersAndProducts(users, products)!=null) {

            Cart cart = (Cart) cartRepository.findByUsersAndProducts(users, products);
            if(cart.getQuantity()>=2) {
                cart.setQuantity(cart.getQuantity() - 1);
                cartRepository.save(cart);
            } else if(cart.getQuantity()==1) {
                removeProduct(userId, productId);
            }
        }
        /*return (Cart) cartRepository.findByUsersAndProducts(users, products);*/

    }
}
