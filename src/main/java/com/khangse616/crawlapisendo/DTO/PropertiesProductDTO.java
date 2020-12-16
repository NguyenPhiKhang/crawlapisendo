package com.khangse616.crawlapisendo.DTO;

import javax.persistence.Column;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.List;

public class PropertiesProductDTO {

    private int id;
    private String name;
    private int admin_id;
    private BigDecimal price;
    private BigDecimal finalPrice;
    private int promotionPercent;
    private boolean promotion;
    private String description;
    private String shortDescription;
    private int weight;
    private int quantity;
    private boolean active;
    private boolean shopFreeShipping;
    private int orderCount;
    private boolean stockStatus;
    private String category;
    private String sku;
    private String skuUser;
    private boolean freeShip;
    private boolean event;
    private String img_url;
    private List<String> images;

    public PropertiesProductDTO() {
    }

    public PropertiesProductDTO(int id, String name, BigDecimal price, BigDecimal finalPrice, int promotionPercent, boolean promotion, String description, String shortDescription, int weight, int quantity, boolean active, boolean shopFreeShipping, int orderCount, boolean stockStatus, String category, String sku, String skuUser, boolean freeShip, boolean event, String img_url, List<String> images, int admin_id) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.finalPrice = finalPrice;
        this.promotionPercent = promotionPercent;
        this.promotion = promotion;
        this.description = description;
        this.shortDescription = shortDescription;
        this.weight = weight;
        this.quantity = quantity;
        this.active = active;
        this.shopFreeShipping = shopFreeShipping;
        this.orderCount = orderCount;
        this.stockStatus = stockStatus;
        this.category = category;
        this.sku = sku;
        this.skuUser = skuUser;
        this.freeShip = freeShip;
        this.event = event;
        this.img_url = img_url;
        this.images = images;
        this.admin_id = admin_id;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(BigDecimal finalPrice) {
        this.finalPrice = finalPrice;
    }

    public int getPromotionPercent() {
        return promotionPercent;
    }

    public void setPromotionPercent(int promotionPercent) {
        this.promotionPercent = promotionPercent;
    }

    public boolean isPromotion() {
        return promotion;
    }

    public void setPromotion(boolean promotion) {
        this.promotion = promotion;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isShopFreeShipping() {
        return shopFreeShipping;
    }

    public void setShopFreeShipping(boolean shopFreeShipping) {
        this.shopFreeShipping = shopFreeShipping;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }

    public boolean isStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(boolean stockStatus) {
        this.stockStatus = stockStatus;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getSkuUser() {
        return skuUser;
    }

    public void setSkuUser(String skuUser) {
        this.skuUser = skuUser;
    }

    public boolean isFreeShip() {
        return freeShip;
    }

    public void setFreeShip(boolean freeShip) {
        this.freeShip = freeShip;
    }

    public boolean isEvent() {
        return event;
    }

    public void setEvent(boolean event) {
        this.event = event;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }
}
