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
    @JoinColumn(name="image_avatar", unique= true, nullable=true, insertable=true, updatable=true)
    private Image imageAvatar;
}

