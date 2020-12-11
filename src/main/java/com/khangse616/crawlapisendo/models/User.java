package com.khangse616.crawlapisendo.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "shops")
public class User {
    @Id
    private int id;

    @Column(name = "name")
    private String name;
    @Column(name = "is_shop")
    private boolean isShop;
    @Column(name = "email")
    private String email;
    @Column(name = "birthday")
    private Date birthday;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "sex")
    private String sex;
    @Column(name = "address")
    private String address;

    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="image_avatar", unique= true, nullable=true, insertable=true, updatable=true, referencedColumnName = "id")
    private Image imageAvatar;

    public User(){}

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

    public boolean isShop() {
        return isShop;
    }

    public void setShop(boolean shop) {
        isShop = shop;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Image getImageAvatar() {
        return imageAvatar;
    }

    public void setImageAvatar(Image imageAvatar) {
        this.imageAvatar = imageAvatar;
    }
}

