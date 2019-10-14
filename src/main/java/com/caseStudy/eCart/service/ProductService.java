package com.caseStudy.eCart.service;

import com.caseStudy.eCart.model.Products;
import com.caseStudy.eCart.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {


    @Autowired
    ProductsRepository productsRepository;

    public List<Products> getProductList() { return productsRepository.findAll(); }

    public Products addOneProduct(Products product) { return productsRepository.save(product); }

    public Optional<Products> getProduct(Long id) {
        return productsRepository.findById(id);
    }

    public List<Products> deleteProduct(Long id) {
        productsRepository.deleteById(id);
        return productsRepository.findAll();
    }

    public List<Products> getProductsByCategory(String category) { return productsRepository.findAllByCategory(category); }

    public List<Products> getProductsByCategoryAndPrice(String category, Double price1, Double price2) {
        return productsRepository.findAllByCategoryAndPriceBetween(category, price1, price2);
    }

    public List<Products> getProductsByPrice(Double price1, Double price2) {
        return productsRepository.findAllByPriceBetween(price1, price2);
    }

    public Products changeProductDescriptions(Products products) {
        Products oldProduct = productsRepository.findByProductId(products.getProductId());
        oldProduct.setProductId(products.getProductId());
        oldProduct.setName(products.getName());
        //oldProduct.setImage(products.getImage());
        oldProduct.setPrice(products.getPrice());
        oldProduct.setCategory(products.getCategory());
        oldProduct.setDetails(products.getDetails());
        productsRepository.saveAndFlush(oldProduct);
        return oldProduct;
    }

}

