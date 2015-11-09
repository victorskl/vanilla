package com.sankholin.vanilla.four.dao;

import com.sankholin.vanilla.four.model.Product;

import java.util.List;

public interface ProductDao {
    List<Product> getAllProducts();

    Product getProductById(String id);

    void addProduct(Product product);

    void removeProduct(Product product);
}