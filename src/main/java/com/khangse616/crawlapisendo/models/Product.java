package com.khangse616.crawlapisendo.models;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "final_price")
    private BigDecimal finalPrice;
    @Column(name = "promotion_percent")
    private int promotionPercent;
    @Column(name = "is_promotion")
    private boolean isPromotion;
    @Column(name = "description")
    private String description;
    @Column(name = "short_description")
    private String shortDescription;
    @Column(name = "weight")
    private int weight;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "is_active")
    private boolean isActive;
    @Column(name = "shop_free_shipping")
    private boolean shopFreeShipping;
    @Column(name = "order_count")
    private int orderCount;
    @Column(name = "stock_status")
    private boolean stockStatus;
    @Column(name = "category")
    private String category;
    @Column(name = "sku")
    private String sku;
    @Column(name = "sku_user")
    private String skuUser;
    @Column(name = "is_free_ship")
    private boolean isFreeShipping;
    @Column(name = "is_event")
    private boolean isEvent;
    @Column(name = "status_record")
    private boolean statusRecord;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "product")
    private RatingStar ratingStar;

    public Product(){}

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
        return isPromotion;
    }

    public void setPromotion(boolean promotion) {
        isPromotion = promotion;
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
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
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

    public boolean isFreeShipping() {
        return isFreeShipping;
    }

    public void setFreeShipping(boolean freeShipping) {
        isFreeShipping = freeShipping;
    }

    public boolean isEvent() {
        return isEvent;
    }

    public void setEvent(boolean event) {
        isEvent = event;
    }

    public RatingStar getRatingStar() {
        return ratingStar;
    }

    public void setRatingStar(RatingStar ratingStar) {
        this.ratingStar = ratingStar;
    }

    public boolean isStatusRecord() {
        return statusRecord;
    }

    public void setStatusRecord(boolean statusRecord) {
        this.statusRecord = statusRecord;
    }
}
