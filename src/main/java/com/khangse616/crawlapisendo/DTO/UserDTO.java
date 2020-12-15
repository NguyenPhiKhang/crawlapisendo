package com.khangse616.crawlapisendo.DTO;

public class UserDTO {
    private int id;
    private String name;
    private String imageAvatar;
    private boolean shop;

    public UserDTO() {
    }

    public UserDTO(int id, String name, String imageAvatar, boolean shop) {
        this.id = id;
        this.name = name;
        this.imageAvatar = imageAvatar;
        this.shop = shop;
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

    public String getImageAvatar() {
        return imageAvatar;
    }

    public void setImageAvatar(String imageAvatar) {
        this.imageAvatar = imageAvatar;
    }

    public boolean isShop() {
        return shop;
    }

    public void setShop(boolean shop) {
        this.shop = shop;
    }
}
