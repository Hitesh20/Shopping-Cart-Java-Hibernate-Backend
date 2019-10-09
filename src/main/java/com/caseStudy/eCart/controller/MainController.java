package com.caseStudy.eCart.controller;


import com.caseStudy.eCart.model.Products;

import com.caseStudy.eCart.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class MainController {

    @Autowired
    ProductService productService;


    @GetMapping("/products")
    public List<Products> getAllProducts() { return productService.getProductList(); }

    @GetMapping("/productsFrom/{category}")
    public List<Products> getProductCategory(@PathVariable("category") String category) {
        return productService.getProductsByCategory(category);
    }

    @GetMapping("/product-detail/{id}")
    public Optional<Products> getProduct(@PathVariable("id") Long id) {
        return productService.getProduct(id);
    }

    @PostMapping("/addProduct")
    public Products addProduct(@RequestBody Products product) {
        return productService.addOneProduct(product);
    }

    @DeleteMapping("/products/{id}/delete")
    public String deleteProduct(@PathVariable("id") Long id)
    {
        return productService.deleteProduct(id);
    }

    /*@GetMapping(path = "/validateLogin", produces = "application/json")
    public String validateLogin() { return "\"valid\""; }*/

    @GetMapping("/products/{category}/{price1}/{price2}")
    public List<Products> getCategoryAndPrice(@PathVariable(value = "category")String category,
                                              @PathVariable(value = "price1")Double price1,
                                              @PathVariable(value = "price2")Double price2) {
        return productService.getProductsByCategoryAndPrice(category, price1, price2);
    }

    @GetMapping("/products/{price1}/{price2}")
    public List<Products> getPrice(@PathVariable(value = "price1")Double price1,
                                   @PathVariable(value = "price2")Double price2) {
        return productService.getProductsByPrice(price1, price2);
    }

    /*@PostMapping(value = "/addUsers")
    public Users addUser(@RequestBody  Users user) { return userService.addUser(user); }*/

}
