package com.khangse616.crawlapisendo.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "shops")
public class Shop {
    @Id
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "good_review_percent")
    private float goodReviewPercent;
    @Column(name = "score")
    private int score;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "warehouse_city")
    private String warehouseCity;
    @Column(name = "is_certified")
    private boolean isCertified;
    @Column(name = "record_status")
    private boolean recordStatus;

    @OneToOne (cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="logo", unique= true, nullable=true, insertable=true, updatable=true)
    private Image logo;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Product> products;

    public Shop(){}

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

    public float getGoodReviewPercent() {
        return goodReviewPercent;
    }

    public void setGoodReviewPercent(float goodReviewPercent) {
        this.goodReviewPercent = goodReviewPercent;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWarehouseCity() {
        return warehouseCity;
    }

    public void setWarehouseCity(String warehouseCity) {
        this.warehouseCity = warehouseCity;
    }

    public boolean isCertified() {
        return isCertified;
    }

    public void setCertified(boolean certified) {
        isCertified = certified;
    }

    public boolean isRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(boolean recordStatus) {
        this.recordStatus = recordStatus;
    }

    public Image getLogo() {
        return logo;
    }

    public void setLogo(Image logo) {
        this.logo = logo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
