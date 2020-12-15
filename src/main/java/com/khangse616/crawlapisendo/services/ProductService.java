package com.khangse616.crawlapisendo.services;

import com.khangse616.crawlapisendo.models.Product;
import com.khangse616.crawlapisendo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ResponseEntity<Object> createUser(Product product) {
//        Product newProduct = new Product();
//        newProduct.setName(product.getName());
        product.setStatusRecord(true);
        product.setTimeCreated(new Timestamp(System.currentTimeMillis()));
        Product savedProduct = productRepository.save(product);
        if (productRepository.findById(savedProduct.getId()).isPresent())
            return ResponseEntity.ok("User Created Successfully");
        else return ResponseEntity.unprocessableEntity().body("Failed Creating User as Specified");
    }
}
