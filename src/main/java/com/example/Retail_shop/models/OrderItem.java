package com.example.Retail_shop.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "order-item",schema = "public",catalog = "Retail")

public class OrderItem {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "order_items_id")
    private long orderItemId;
    @Column(name = "order_items_quanity")
    private int orderItemQuanity;
    @Column(name = "order_items_price")
    private int orderItemPrice;
}
