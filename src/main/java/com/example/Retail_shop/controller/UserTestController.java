package com.example.Retail_shop.controller;

import com.example.Retail_shop.dal.DataAccessLayer;
import com.example.Retail_shop.models.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
@RestController
@RequestMapping("/secured")
public class UserTestController {
    private DataAccessLayer dataAccessLayer;
    public UserTestController(DataAccessLayer dataAccessLayer) {
        this.dataAccessLayer = dataAccessLayer;
    }

    @GetMapping("/user")
    public String userAcross(Principal principal) {
        if (principal != null) {
            return principal.getName();
        }
        return null;
    }

    @PostMapping("/create/categories")
    public ResponseEntity<String> createCategories(@RequestBody Categories categories) {
        dataAccessLayer.createCategories(categories);
        return ResponseEntity.ok("Categories created");
    }

    @PostMapping("/create/order")
    public ResponseEntity<String> createOrder(@RequestBody Order order) {
        dataAccessLayer.createOrder(order);
        return ResponseEntity.ok("Order created");
    }

    @PostMapping("/create/order-item")
    public ResponseEntity<String> createOrderItem(@RequestBody OrderItem orderItem) {
        dataAccessLayer.createOrderItem(orderItem);
        return ResponseEntity.ok("Order item created");
    }

    @PostMapping("/create/payments")
    public ResponseEntity<String> createPayments(@RequestBody Payments payments) {
        dataAccessLayer.createPayments(payments);
        return ResponseEntity.ok("Payments created");
    }

    @PostMapping("/create/products")
    public ResponseEntity<String> createProducts(@RequestBody Products products) {
        dataAccessLayer.createProducts(products);
        return ResponseEntity.ok("Products created");
    }

    @PostMapping("/create/reviews")
    public ResponseEntity<String> createReviews(@RequestBody Reviews reviews) {
        dataAccessLayer.createReviews(reviews);
        return ResponseEntity.ok("Reviews created");
    }

    @PostMapping("/create/users")
    public ResponseEntity<String> createUsers(@RequestBody Users user) {
        dataAccessLayer.createUsers(user);
        return ResponseEntity.ok("Users created");
    }
}
