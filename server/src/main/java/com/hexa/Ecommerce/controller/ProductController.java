package com.hexa.Ecommerce.controller;


import com.hexa.Ecommerce.model.Product;
import com.hexa.Ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Component
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")  // React frontend origin
public class ProductController {

    @Autowired
    private ProductService service;
    @RequestMapping("/")
    public String greet() {
        return "Hello World!";
    }

    @RequestMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {

        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
//        for(Product pro : ans) System.out.println(pro.getId()+" "+pro.getName()+" "+pro.getQuantity()+" "+pro.getBrand()+" "+pro.getDesc()+" "+pro.getCategory()+" "+pro.getPrice()+" "+pro.getRelease_Date());
    }
}
