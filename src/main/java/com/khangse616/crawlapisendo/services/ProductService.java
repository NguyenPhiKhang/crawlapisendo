package com.khangse616.crawlapisendo.services;

import com.khangse616.crawlapisendo.DTO.*;
import com.khangse616.crawlapisendo.controllers.ImageController;
import com.khangse616.crawlapisendo.messages.ResponseMessage;
import com.khangse616.crawlapisendo.models.*;
import com.khangse616.crawlapisendo.repositories.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    public Product findProductById(int id) {
        return productRepository.findById(id).get();
    }

    public String deleteImages() {
//        Page<Product> products = productRepository.findAll(PageRequest.of(1, 5247, Sort.by(Sort.Direction.ASC, "id")));
//        DeleteImg(products, 5247, 10000);

        Page<Product> products1 = productRepository.findAll(PageRequest.of(2, 8000, Sort.by(Sort.Direction.ASC, "id")));
        DeleteImg(products1, 16000, 20000);

        Page<Product> products2 = productRepository.findAll(PageRequest.of(3, 8300, Sort.by(Sort.Direction.ASC, "id")));
        DeleteImg(products2, 249000, 0);

        Page<Product> products3 = productRepository.findAll(PageRequest.of(4, 8300, Sort.by(Sort.Direction.ASC, "id")));
        DeleteImg(products3, 33200, 0);

        Page<Product> products4 = productRepository.findAll(PageRequest.of(8, 5800, Sort.by(Sort.Direction.ASC, "id")));
        DeleteImg(products4, 46400, 0);

        Page<Product> products5 = productRepository.findAll(PageRequest.of(9, 5800, Sort.by(Sort.Direction.ASC, "id")));
        DeleteImg(products4, 52200, 0);


        return "done";
    }

    private void DeleteImg(Page<Product> products, int stt, int max) {
        int index = stt;
        for (Product product : products) {
            if (max != 0 && index > max)
                return;
            System.out.println("product thu " + index++);
            if (product.getImages().size() > 2) {
                List<String> imageIds = product.getImages().stream().map(Image::getId).collect(Collectors.toList());
                for (int i = 2; i < imageIds.size(); i++) {
                    product.removeImage(imageRepository.getOne(imageIds.get(i)));
                    imageRepository.deleteById(imageIds.get(i));
                    System.out.println("product: " + product.getId() + " - image id: " + imageIds.get(i));
                }
            }
        }
    }

    public String createProduct(ProductDTO productDTO) throws IOException {
        PropertiesProductDTO propertiesProductDTO = productDTO.getProperties();
        if (productRepository.findById(propertiesProductDTO.getId()).isPresent())
            return "exists key product";
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
        product.setTimeCreated(new Timestamp(System.currentTimeMillis()));
        product.setTimeUpdated(new Timestamp(System.currentTimeMillis()));
        product.setStatusRecord(true);

        if (!propertiesProductDTO.getImg_url().equals("")) {
//            ResponseMessage<Image> image = imageController.uploadFile(propertiesProductDTO.getImg_url()).getBody();
            ResponseMessage<Image> image = imageController.uploadImageLink(propertiesProductDTO.getImg_url()).getBody();
            assert image != null;
            if (!image.getMessage().equals(""))
                product.setImgUrl(image.getData());
        }

        ResponseMessage<List<Image>> images = imageController.uploadImageLinks(propertiesProductDTO.getImages().toArray(String[]::new)).getBody();
        assert images != null;
        product.setImages(new HashSet<>(images.getData()));


        List<UserDTO> userDTOS = productDTO.getUsers();
        for (UserDTO userDTO : userDTOS) {
            if (userRepository.existsById(userDTO.getId())) { // exist USER
                if (!userRepository.existsByIdAndShopTrue(userDTO.getId())) { // not is SHOP
                    if (userDTO.getFrom().equals("shop")
//                            || (userDTO.getFrom().equals("comment")&&userDTO.isShop())
                    ) {
                        User user = userRepository.findById(userDTO.getId()).get();
                        user.setShop(userDTO.isShop());
                        userRepository.save(user);
                    }
                } else { // is SHOP
                    if (!userDTO.getFrom().equals("shop")) {
                        if (!userRepository.existsByIdAndName(userDTO.getId(), userDTO.getName())) {
                            User user = userRepository.findById(userDTO.getId()).get();
                            user.setName(userDTO.getName());
                            Image oldImage = user.getImageAvatar();
                            if (!userDTO.getImageAvatar().equals("")) {
                                ResponseMessage<Image> image = imageController.uploadImageLink(userDTO.getImageAvatar()).getBody();
                                assert image != null;
                                if (!image.getMessage().equals("")) {
                                    user.setImageAvatar(image.getData());
                                    if (oldImage != null)
                                        imageRepository.delete(oldImage);
                                }
                            }
                            userRepository.save(user);
                        }
                    }
                }
            } else { // not exists USER
                User user = new User();
                user.setId(userDTO.getId());
                user.setName(userDTO.getName());
                user.setRecordStatus(true);
                user.setShop(userDTO.isShop());
                if (!userDTO.getImageAvatar().equals("")) {
                    ResponseMessage<Image> image = imageController.uploadImageLink(userDTO.getImageAvatar()).getBody();
                    assert image != null;
                    if (!image.getMessage().equals(""))
                        user.setImageAvatar(image.getData());
                }
                user.setTimeCreated(new Timestamp(System.currentTimeMillis()));
                user.setTimeUpdated(new Timestamp(System.currentTimeMillis()));

                userRepository.save(user);
            }
        }

        ShopDTO shopDTO = productDTO.getShop();
        if (!shopRepository.existsById(shopDTO.getId())) {
            Shop shop = new Shop();
            shop.setId(shopDTO.getId());
            shop.setName(shopDTO.getName());
            shop.setGoodReviewPercent((shopDTO.getGoodReviewPercent()));
            shop.setScore(shopDTO.getScore());
            shop.setPhoneNumber(shopDTO.getPhoneNumber());
            shop.setWarehouseCity(shopDTO.getWarehouseCity());
            shop.setCertified(shopDTO.isCertified());
            if (!shopDTO.getLogo().equals("")) {
                ResponseMessage<Image> image = imageController.uploadImageLink(shopDTO.getLogo()).getBody();
                assert image != null;
                if (!image.getMessage().equals(""))
                    shop.setLogo(image.getData());
            }

            User user = userRepository.findById(shopDTO.getUser()).get();
            shop.setUser(user);
            shop.setTimeCreated(new Timestamp(System.currentTimeMillis()));
            shop.setTimeUpdated(new Timestamp(System.currentTimeMillis()));
            shop.setRecordStatus(true);

            product.setShop(shopRepository.save(shop));
        } else {
            product.setShop(shopRepository.findById(shopDTO.getId()).get());
        }

        CategoriesProductDTO categoriesProductDTO = productDTO.getCategories();
        if (!categoryRepository.existsById(categoriesProductDTO.getCategory_level1_id())) {
            Category category = new Category();
            category.setId(categoriesProductDTO.getCategory_level1_id());
            category.setLevel(1);
            category.setName(categoriesProductDTO.getCategory_level1_name());
            category.setCategoryPath(categoriesProductDTO.getCategory_level1_path());

            categoryRepository.save(category);
        }
        if (!categoryRepository.existsById(categoriesProductDTO.getCategory_level2_id())) {
            Category category = new Category();
            category.setId(categoriesProductDTO.getCategory_level2_id());
            category.setLevel(2);
            category.setName(categoriesProductDTO.getCategory_level2_name());
            category.setCategoryPath(categoriesProductDTO.getCategory_level2_path());
            category.setParentCategory(categoryRepository.findById(categoriesProductDTO.getCategory_level1_id()).get());

            categoryRepository.save(category);
        }
        if (!categoryRepository.existsById(categoriesProductDTO.getCategory_level3_id())) {
            Category category = new Category();
            category.setId(categoriesProductDTO.getCategory_level3_id());
            category.setLevel(3);
            category.setName(categoriesProductDTO.getCategory_level3_name());
            category.setCategoryPath(categoriesProductDTO.getCategory_level3_path());
            category.setParentCategory(categoryRepository.findById(categoriesProductDTO.getCategory_level2_id()).get());

            categoryRepository.save(category);
        }

        Set<Category> categories = new HashSet<>(categoryRepository.findAllCategoryByProduct(categoriesProductDTO.getCategory_level1_id(), categoriesProductDTO.getCategory_level2_id(), categoriesProductDTO.getCategory_level3_id()));
        product.setCategories(categories);

        List<AttributeDTO> attributeDTOS = productDTO.getAttributes();
        for (AttributeDTO attributeDTO : attributeDTOS) {
            if (!attributeRepository.existsById(attributeDTO.getId())) {
                Attribute attribute = new Attribute();
                attribute.setId(attributeDTO.getId());
                attribute.setName(attributeDTO.getName());

                attributeRepository.save(attribute);
            }

        }

        List<OptionDTO> optionDTOS = productDTO.getOptions();
        for (OptionDTO optionDTO : optionDTOS) {
            if (!optionRepository.existsById(optionDTO.getId())) {
                Option option = new Option();
                option.setId(optionDTO.getId());
                option.setValue(optionDTO.getValue());
                option.setAttribute(attributeRepository.findById(optionDTO.getAttribute()).get());

                optionRepository.save(option);
            }
        }

        product.setOptions(new HashSet<>(optionRepository.findByIdIn(optionDTOS.stream().map(OptionDTO::getId).collect(Collectors.toList()))));

        RatingStarDTO ratingStarDTO = productDTO.getRating_star();
        RatingStar ratingStar = new RatingStar(propertiesProductDTO.getId(), ratingStarDTO.getStar1(), ratingStarDTO.getStar2(), ratingStarDTO.getStar3(), ratingStarDTO.getStar4(), ratingStarDTO.getStar5());

        product.setRatingStar(ratingStarRepository.save(ratingStar));

        Product productSaved = productRepository.save(product);
        List<CommentDTO> commentDTOS = productDTO.getComments();
        for (CommentDTO commentDTO : commentDTOS) {
            Comment comment = new Comment();
            comment.setId(commentDTO.getId());
            comment.setParentId(commentDTO.getParent_id());
            comment.setData(commentDTO.getData());
            comment.setTimeCreated(new Timestamp(System.currentTimeMillis()));
            comment.setTimeUpdated(new Timestamp(System.currentTimeMillis()));
            comment.setUser(userRepository.findById(commentDTO.getCustomer_id()).get());
            comment.setProduct(productSaved);

            commentRepository.save(comment);
        }

        List<RatingDTO> ratingDTOS = productDTO.getRatings();
        for (RatingDTO ratingDTO : ratingDTOS) {
            Rating rating = new Rating();
            rating.setId(ratingDTO.getId());
            rating.setComment(ratingDTO.getComment());
            rating.setStar(ratingDTO.getStar());
            rating.setTimeCreated(new Timestamp(System.currentTimeMillis()));
            rating.setTimeUpdated(new Timestamp(System.currentTimeMillis()));
            rating.setUser(userRepository.findById(ratingDTO.getUser()).get());
            rating.setProduct(productSaved);

            ratingRepository.save(rating);
        }

        return String.valueOf(productDTO.getProperties().getId());
    }
}
