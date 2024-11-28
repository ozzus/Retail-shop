package com.example.Retail_shop.dal;

import com.example.Retail_shop.models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

@Component
public class DataAccessLayer {
    private SessionFactory sessionFactory;
    @Autowired
    public DataAccessLayer(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    Session session = null;

//    Post

    public void createCategories(Categories newCategory) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(newCategory);
        session.getTransaction().commit();
        if (session != null) {
        session.close();
        }
    }

    public void createOrder(Order newOrder) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(newOrder);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }

    public void createOrderItem(OrderItem newOrderItem) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(newOrderItem);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }

    public void createPayments(Payments newPayments) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(newPayments);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }

    public void createProducts(Products newProducts) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(newProducts);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }

    public void createReviews(Reviews newReviews) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(newReviews);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }

    public void createUsers(Users newUsers) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(newUsers);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }

//    Delete

    public void deleteCategoriesById(long id){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Categories categories = session.get(Categories.class, id);
        session.remove(categories);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }

    public void deleteOrderById(long id){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Order order = session.get(Order.class, id);
        session.remove(order);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }

    public void deleteOrderItemById(long id){
        session = sessionFactory.openSession();
        session.beginTransaction();
        OrderItem orderItem = session.get(OrderItem.class, id);
        session.remove(orderItem);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }

    public void deletePaymentsById(long id){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Payments payments = session.get(Payments.class, id);
        session.remove(payments);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }

    public void deleteProductsById(long id){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Products products = session.get(Products.class, id);
        session.remove(products);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }

    public void deleteReviewsById(long id){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Reviews reviews = session.get(Reviews.class, id);
        session.remove(reviews);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }

    public void deleteUserById(long id){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Users users = session.get(Users.class, id);
        session.remove(users);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }

//    Get

    public Categories getCategoriesById(long id){
        session = sessionFactory.openSession();
        session.beginTransaction();
        try{
            Categories categories = session.get(Categories.class, id);
            return categories;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Order getOrderById(long id){
        session = sessionFactory.openSession();
        session.beginTransaction();
        try{
            Order order = session.get(Order.class, id);
            return order;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public OrderItem getOrderItemById(long id){
        session = sessionFactory.openSession();
        session.beginTransaction();
        try{
            OrderItem orderItem = session.get(OrderItem.class, id);
            return orderItem;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }


    public Payments getPaymentsById(long id){
        session = sessionFactory.openSession();
        session.beginTransaction();
        try{
            Payments payments = session.get(Payments.class, id);
            return payments;
        } finally{
            if (session != null) {
                session.close();
            }
        }
    }

    public Products getProductsById(long id){
        session = sessionFactory.openSession();
        session.beginTransaction();
        try{
            Products products = session.get(Products.class, id);
            return products;
        } finally{
            if (session != null) {
                session.close();
            }
        }
    }

    public Reviews getReviewsById(long id){
        session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            Reviews reviews = session.get(Reviews.class, id);
            return reviews;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Users getUsersById(long id){
        session = sessionFactory.openSession();
        session.beginTransaction();
        try{
            Users users = session.get(Users.class, id);
            return users;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

//    Patch

    public void updateCategories(long id,Categories updatecategories){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Categories categories = session.get(Categories.class, id);

    }







}
