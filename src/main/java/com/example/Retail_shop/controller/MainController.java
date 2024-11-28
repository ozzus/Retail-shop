package com.example.Retail_shop.controller;


import com.example.Retail_shop.dal.DataAccessLayer;
import com.example.Retail_shop.models.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/unauthorized")
@Slf4j
public class MainController {
    private DataAccessLayer dataAccessLayer;
    @Autowired
    public MainController(DataAccessLayer dataAccessLayer)
    {
        this.dataAccessLayer = dataAccessLayer;
    }

//    Post

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

    @PostMapping("/create/order_item")
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

    @PostMapping("/create/user")
    public ResponseEntity<String> createUsers(@RequestBody Users user) {
        dataAccessLayer.createUsers(user);
        return ResponseEntity.ok("Users created");
    }


//    Delete

    @DeleteMapping("/delete/categories/{id}")
    public ResponseEntity<String> deleteCategoriesById(@PathVariable long id) {
        dataAccessLayer.deleteCategoriesById(id);
        return ResponseEntity.ok("Categories deleted");
    }

    @DeleteMapping("/delete/order/{id}")
    public ResponseEntity<String> deleteOrderById(@PathVariable long id) {
        dataAccessLayer.deleteOrderById(id);
        return ResponseEntity.ok("Order deleted");
    }

    @DeleteMapping("/delete/order_item/{id}")
    public ResponseEntity<String> deleteOrderItemById(@PathVariable long id) {
        dataAccessLayer.deleteOrderItemById(id);
        return ResponseEntity.ok("Order item deleted");
    }

    @DeleteMapping("/delete/payments/{id}")
    public ResponseEntity<String> deletePaymentsById(@PathVariable long id) {
        dataAccessLayer.deletePaymentsById(id);
        return ResponseEntity.ok("Payments deleted");
    }

    @DeleteMapping("/delete/products/{id}")
    public ResponseEntity<String> deleteProductsById(@PathVariable long id) {
        dataAccessLayer.deleteProductsById(id);
        return ResponseEntity.ok("Products deleted");
    }

    @DeleteMapping("/delete/reviews/{id}")
    public ResponseEntity<String> deleteReviewsById(@PathVariable long id) {
        dataAccessLayer.deleteReviewsById(id);
        return ResponseEntity.ok("Reviews deleted");
    }

    @DeleteMapping("/delete/users/{id}")
    public ResponseEntity<String> deleteUsersById(@PathVariable long id) {
        dataAccessLayer.deleteUserById(id);
        return ResponseEntity.ok("Users deleted");
    }

//    Get

    @GetMapping("/get/categories/{id}")
    public ResponseEntity<Categories> getClientById(@PathVariable("id") long id){
        Categories categories = dataAccessLayer.getCategoriesById(id);
        if (categories == null) {
            return ResponseEntity.notFound().build();
        } else{
            return ResponseEntity.ok(categories);
        }
    }

    @GetMapping("/get/order/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("id") long id){
        Order order = dataAccessLayer.getOrderById(id);
        if (order == null) {
            return ResponseEntity.notFound().build();
        } else{
            return ResponseEntity.ok(order);
        }
    }

    @GetMapping("/get/order_item/{id}")
    public ResponseEntity<OrderItem> getOrderItemById(@PathVariable("id") long id){
        OrderItem orderItem = dataAccessLayer.getOrderItemById(id);
        if (orderItem == null) {
            return ResponseEntity.notFound().build();
        } else{
            return ResponseEntity.ok(orderItem);
        }
    }

    @GetMapping("/get/payments/{id}")
    public ResponseEntity<Payments> getPaymentsById(@PathVariable("id") long id){
        Payments payments = dataAccessLayer.getPaymentsById(id);
        if (payments == null) {
            return ResponseEntity.notFound().build();
        } else{
            return ResponseEntity.ok(payments);
        }
    }

    @GetMapping("/get/products/{id}")
    public ResponseEntity<Products> getProductsById(@PathVariable("id") long id){
        Products products = dataAccessLayer.getProductsById(id);
        if (products == null) {
            return ResponseEntity.notFound().build();
        } else{
            return ResponseEntity.ok(products);
        }
    }

    @GetMapping("/get/reviews/{id}")
    public ResponseEntity<Reviews> getReviewsById(@PathVariable("id") long id){
        Reviews reviews = dataAccessLayer.getReviewsById(id);
        if (reviews == null) {
            return ResponseEntity.notFound().build();
        } else{
            return ResponseEntity.ok(reviews);
        }
    }

    @GetMapping("/get/users/{id}")
    public ResponseEntity<Users> getUsersById(@PathVariable("id") long id){
        Users users = dataAccessLayer.getUsersById(id);
        if (users == null) {
            return ResponseEntity.notFound().build();
        } else{
            return ResponseEntity.ok(users);
        }
    }

//    Patch

    @PatchMapping("/patch/categories/{id}")
    public ResponseEntity<Categories> updateCategories(@RequestBody Categories categories, @PathVariable long id) {}







}
