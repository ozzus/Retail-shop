package com.example.Retail_shop.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "reviews",schema = "public",catalog = "Retail")

public class Reviews {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "reviews_id")
    private int reviewsId;
    @Column(name = "reviews_product_id")
    private int reviewsProductId;
    @Column(name = "reviews_user_id")
    private int reviewsUserId;
    @Column(name = "reviews_rating")
    private int reviewsRating;
    @Column(name = "reviews_review_date")
    private String reviewsReviewDate;
}
