package com.sankholin.vanilla.four.service;

import com.sankholin.vanilla.four.dao.ProductDao;
import com.sankholin.vanilla.four.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private transient ProductDao productDao;

    @Override
    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }

    @Override
    public void addProduct(Product product) {
        product.setId(UUID.randomUUID().toString());
        productDao.addProduct(product);
    }

    @Override
    public Product getProductById(String id) {
        return productDao.getProductById(id);
    }

    @Override
    public void removeProduct(Product product) {
        productDao.removeProduct(product);
    }

    @Override
    public void removeProductById(String id) {
        productDao.removeProduct(productDao.getProductById(id));
    }
}