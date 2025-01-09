package com.hexa.Ecommerce.service;

import com.hexa.Ecommerce.model.Product;
import com.hexa.Ecommerce.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;
    public List<Product> getAllProducts() {
        List<Product> ans = repo.findAll();
        return ans;
    }
}
