package com.khangse616.crawlapisendo.services;

import com.khangse616.crawlapisendo.DTO.CategoriesProductDTO;
import com.khangse616.crawlapisendo.DTO.ProductDTO;
import com.khangse616.crawlapisendo.DTO.PropertiesProductDTO;
import com.khangse616.crawlapisendo.DTO.UserDTO;
import com.khangse616.crawlapisendo.controllers.ImageController;
import com.khangse616.crawlapisendo.messages.ResponseMessage;
import com.khangse616.crawlapisendo.models.Image;
import com.khangse616.crawlapisendo.models.Product;
import com.khangse616.crawlapisendo.models.User;
import com.khangse616.crawlapisendo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    @Autowired
    private ImageController imageController;


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

    public String createProduct(ProductDTO productDTO) throws IOException {
        PropertiesProductDTO propertiesProductDTO = productDTO.getProperties();
        Product product = new Product();
        product.setId(propertiesProductDTO.getId());
        product.setName(propertiesProductDTO.getName());
        product.setFinalPrice(propertiesProductDTO.getFinalPrice());
        product.setPrice(propertiesProductDTO.getPrice());
        product.setPromotion(propertiesProductDTO.isPromotion());
        product.setPromotionPercent(propertiesProductDTO.getPromotionPercent());
        product.setDescription(propertiesProductDTO.getDescription());
        product.setShortDescription(propertiesProductDTO.getShortDescription());
        product.setWeight(propertiesProductDTO.getWeight());
        product.setQuantity(propertiesProductDTO.getQuantity());
        product.setShopFreeShipping(propertiesProductDTO.isShopFreeShipping());
        product.setOrderCount(propertiesProductDTO.getOrderCount());
        product.setStockStatus(propertiesProductDTO.isStockStatus());
        product.setCategory(propertiesProductDTO.getCategory());
        product.setSku(propertiesProductDTO.getSku());
        product.setSkuUser(propertiesProductDTO.getSkuUser());
        product.setFreeShip(propertiesProductDTO.isFreeShip());
        product.setEvent(propertiesProductDTO.isEvent());
        product.setActive(propertiesProductDTO.isActive());

        if(!propertiesProductDTO.getImg_url().equals("")){
            ResponseMessage<Image> image = imageController.uploadFile(propertiesProductDTO.getImg_url()).getBody();
            assert image != null;
            product.setImgUrl(image.getData());
        }

        ResponseMessage<List<Image>> images = imageController.uploadFile(propertiesProductDTO.getImages().toArray(String[]::new)).getBody();
        assert images != null;
        product.setImages(new HashSet<>(images.getData()));

//        for (String image_url: productDTO.getProperties().getImages()){
//            if(!image_url.equals("")){
//                ResponseMessage<Image> image = imageController.uploadFile(propertiesProductDTO.getImg_url()).getBody();
//                assert image != null;
//                product.setImgUrl(image.getData());
//            }
//        }
        productRepository.save(product);
        return String.valueOf(productDTO.getProperties().getId());
    }
}
