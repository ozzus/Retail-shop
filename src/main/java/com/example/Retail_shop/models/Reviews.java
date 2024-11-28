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
    private long reviewsId;
    @Column(name = "reviews_rating")
    private int reviewsRating;
    @Column(name = "reviews_comment")
    private String reviewsComment;
    @Column(name = "reviews_review_date")
    private String reviewsReviewDate;
}
