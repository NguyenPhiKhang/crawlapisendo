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

}
