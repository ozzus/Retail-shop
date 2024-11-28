package com.example.Retail_shop.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "payments",schema = "public",catalog = "Retail")

public class Payments {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "payments_payment_date")
    private int paymentsPaymentDate;
    @Column(name = "payments_amount")
    private int paymentsAmount;
    @Column(name = "payments_payments_method")
    private String paymentsPaymentsMethod;

}
