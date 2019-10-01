package com.caseStudy.eCart.service;

import com.caseStudy.eCart.model.Products;
import com.caseStudy.eCart.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductService {


    @Autowired
    ProductsRepository productsRepository;

    public List<Products> getProductList() {
        return productsRepository.findAll();
    }

    public Products addOneProduct(Products product) {
        return productsRepository.save(product);

    }

    public Optional<Products> getProduct(Long id) {
        return productsRepository.findById(id);
    }

    public String deleteProduct(Long id) {
        productsRepository.deleteById(id);
        return "deleted";
    }
}
