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

    public List<Products> getProductList() { return productsRepository.findAll(); }

    public Products addOneProduct(Products product) { return productsRepository.save(product); }

    public Optional<Products> getProduct(Long id) {
        return productsRepository.findById(id);
    }

    public String deleteProduct(Long id) {
        productsRepository.deleteById(id);
        return "deleted";
    }

    public List<Products> getProductsByCategory(String category) { return productsRepository.findAllByCategory(category); }

    public List<Products> getProductsByCategoryAndPrice(String category, Double price1, Double price2) {
        return productsRepository.findAllByCategoryAndPriceBetween(category, price1, price2);
    }

    public List<Products> getProductsByPrice(Double price1, Double price2) {
        return productsRepository.findAllByPriceBetween(price1, price2);
    }
}

