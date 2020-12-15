package com.khangse616.crawlapisendo.services;

import com.khangse616.crawlapisendo.DTO.CategoriesProductDTO;
import com.khangse616.crawlapisendo.DTO.ProductDTO;
import com.khangse616.crawlapisendo.DTO.PropertiesProductDTO;
import com.khangse616.crawlapisendo.models.Product;
import com.khangse616.crawlapisendo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AttributeRepository attributeRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ShopRepository shopRepository;
    @Autowired
    private RatingStarRepository ratingStarRepository;
    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private OptionRepository optionRepository;
    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private CommentRepository commentRepository;


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

    public String createProduct(ProductDTO productDTO){
        PropertiesProductDTO propertiesProductDTO = productDTO.getProperties();
        Product product = new Product();
        product.setId(propertiesProductDTO.getId());
        product.set
        return String.valueOf(productDTO.getProperties().getId());
    }
}
