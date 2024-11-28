package com.example.Retail_shop.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "products",schema = "public",catalog = "Retail")
public class Products {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "products_id")
    private int productsId;
    @Column(name = "products_name")
    private String productsName;
    @Column(name = "products_description")
    private String productsDescription;
    @Column(name = "products_price")
    private double productsPrice;
    @Column(name = "products_stock_quanity")
    private double productsStockQuanity;
    @Column(name = "products_category_id")
    private int productsCategoryId;
}


