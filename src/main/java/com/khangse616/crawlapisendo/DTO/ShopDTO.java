package com.khangse616.crawlapisendo.DTO;

import javax.persistence.Column;

public class ShopDTO {
    private int id;
    private String name;
    private float goodReviewPercent;
    private int score;
    private String phoneNumber;
    private String warehouseCity;
    private boolean certified;
    private String logo;
    private int user;

    public ShopDTO() {
    }

    public ShopDTO(int id, String name, float goodReviewPercent, int score, String phoneNumber, String warehouseCity, boolean certified, String logo, int user) {
        this.id = id;
        this.name = name;
        this.goodReviewPercent = goodReviewPercent;
        this.score = score;
        this.phoneNumber = phoneNumber;
        this.warehouseCity = warehouseCity;
        this.certified = certified;
        this.logo = logo;
        this.user = user;
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
        return certified;
    }

    public void setCertified(boolean certified) {
        this.certified = certified;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }
}
