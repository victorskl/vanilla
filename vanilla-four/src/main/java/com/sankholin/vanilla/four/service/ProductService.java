package com.sankholin.vanilla.four.service;

import com.sankholin.vanilla.four.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    void addProduct(Product product);

    Product getProductById(String id);

    void removeProduct(Product product);

    void removeProductById(String id);
}