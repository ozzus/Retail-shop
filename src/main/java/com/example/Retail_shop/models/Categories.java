package com.example.Retail_shop.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "categories",schema = "public",catalog = "Retail")

public class Categories {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "categories_id")
    private int categoriesId;
    @Column(name = "categories_name")
    private String categoriesName;
    @Column(name = "categories_description")
    private String categoriesDescription;
}
