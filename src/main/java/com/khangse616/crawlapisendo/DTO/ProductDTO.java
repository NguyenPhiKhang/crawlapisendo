package com.khangse616.crawlapisendo.DTO;

import java.util.List;

public class ProductDTO {
    private PropertiesProductDTO properties;
    private List<UserDTO> users;
    private List<CommentDTO> comments;
    private RatingStarDTO rating_star;
    private List<RatingDTO> ratings;
    private List<AttributeDTO> attributes;
    private List<OptionDTO> options;
    private ShopDTO shop;
    private CategoriesProductDTO categories;

    public ProductDTO() {
    }

    public ProductDTO(PropertiesProductDTO properties, List<UserDTO> users, List<CommentDTO> comments, RatingStarDTO rating_star, List<RatingDTO> ratings, List<AttributeDTO> attributes, List<OptionDTO> options, ShopDTO shop, CategoriesProductDTO categories) {
        this.properties = properties;
        this.users = users;
        this.comments = comments;
        this.rating_star = rating_star;
        this.ratings = ratings;
        this.attributes = attributes;
        this.options = options;
        this.shop = shop;
        this.categories = categories;
    }

    public PropertiesProductDTO getProperties() {
        return properties;
    }

    public void setProperties(PropertiesProductDTO properties) {
        this.properties = properties;
    }

    public RatingStarDTO getRating_star() {
        return rating_star;
    }

    public void setRating_star(RatingStarDTO rating_star) {
        this.rating_star = rating_star;
    }

    public ShopDTO getShop() {
        return shop;
    }

    public void setShop(ShopDTO shop) {
        this.shop = shop;
    }

    public CategoriesProductDTO getCategories() {
        return categories;
    }

    public void setCategories(CategoriesProductDTO categories) {
        this.categories = categories;
    }

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }

    public List<CommentDTO> getComments() {
        return comments;
    }

    public void setComments(List<CommentDTO> comments) {
        this.comments = comments;
    }

    public List<RatingDTO> getRatings() {
        return ratings;
    }

    public void setRatings(List<RatingDTO> ratings) {
        this.ratings = ratings;
    }

    public List<AttributeDTO> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<AttributeDTO> attributes) {
        this.attributes = attributes;
    }

    public List<OptionDTO> getOptions() {
        return options;
    }

    public void setOptions(List<OptionDTO> options) {
        this.options = options;
    }
}
