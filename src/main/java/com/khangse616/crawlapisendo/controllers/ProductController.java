package com.khangse616.crawlapisendo.controllers;

import com.khangse616.crawlapisendo.models.Product;
import com.khangse616.crawlapisendo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("http://localhost:3000")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    public Object createProduct(@RequestBody Product product){
        return productService.createUser(product);
    }
}