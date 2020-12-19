package com.khangse616.crawlapisendo.controllers;

import com.khangse616.crawlapisendo.DTO.CategoriesProductDTO;
import com.khangse616.crawlapisendo.DTO.ProductDTO;
import com.khangse616.crawlapisendo.exceptions.ResourceNotFoundException;
import com.khangse616.crawlapisendo.models.Image;
import com.khangse616.crawlapisendo.models.Product;
import com.khangse616.crawlapisendo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

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

    @PostMapping("/test")
    public String testCategory(@RequestBody ProductDTO productDTO) throws IOException {
        return productService.createProduct(productDTO);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id) {
        return ResponseEntity.ok().body(productService.findProductById(id));
    }

    @DeleteMapping("/product/delete-images")
    public String deleteImage(){
       return productService.deleteImages();
    }
}