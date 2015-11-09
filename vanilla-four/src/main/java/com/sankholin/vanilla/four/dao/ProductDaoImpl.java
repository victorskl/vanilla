package com.sankholin.vanilla.four.dao;

import com.sankholin.vanilla.four.model.Product;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class ProductDaoImpl implements ProductDao {

    private List<Product> products = new ArrayList<>();

    public ProductDaoImpl() {
        Product product = new Product();
        product.setId(UUID.randomUUID().toString());
        product.setName("Jack Daniels");
        product.setPrice(new BigDecimal(59));
        product.setStockCount(10);
        products.add(product);

        product = new Product();
        product.setId(UUID.randomUUID().toString());
        product.setName("Chivas");
        product.setPrice(new BigDecimal(59));
        product.setStockCount(10);
        products.add(product);

        product = new Product();
        product.setId(UUID.randomUUID().toString());
        product.setName("Johnnie Walker");
        product.setPrice(new BigDecimal(59));
        product.setStockCount(10);
        products.add(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public Product getProductById(String id) {
        for (Product product : products) {
            if (product.getId().equalsIgnoreCase(id)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public void removeProduct(Product product) {
        products.remove(product);
    }
}