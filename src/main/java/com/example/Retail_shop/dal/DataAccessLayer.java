package com.example.Retail_shop.dal;

import com.example.Retail_shop.models.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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
        categories.setCategoriesName(updatecategories.getCategoriesName());
        categories.setCategoriesDescription(updatecategories.getCategoriesDescription());
        session.merge(categories);
        session.getTransaction().commit();
    }

    public void updateOrder(long id,Order updateorder){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Order order = session.get(Order.class, id);
        order.setOrderDate(updateorder.getOrderDate());
        order.setOrderTotalAmount(updateorder.getOrderTotalAmount());
        order.setOrderStatus(updateorder.getOrderStatus());
        session.merge(order);
        session.getTransaction().commit();
    }

    public void updateOrderItem(long id,OrderItem updateorderitem){
        session = sessionFactory.openSession();
        session.beginTransaction();
        OrderItem orderItem = session.get(OrderItem.class, id);
        orderItem.setOrderItemQuanity(updateorderitem.getOrderItemQuanity());
        orderItem.setOrderItemPrice(updateorderitem.getOrderItemPrice());
        session.merge(orderItem);
        session.getTransaction().commit();
    }

    public void updatePayments(long id,Payments updatepayments){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Payments payments = session.get(Payments.class, id);
        payments.setPaymentsPaymentDate(updatepayments.getPaymentsPaymentDate());
        payments.setPaymentsAmount(updatepayments.getPaymentsAmount());
        payments.setPaymentsPaymentsMethod(updatepayments.getPaymentsPaymentsMethod());
        session.merge(payments);
        session.getTransaction().commit();
    }

    public void updateProducts(long id,Products updateproducts){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Products products = session.get(Products.class, id);
        products.setProductsName(updateproducts.getProductsName());
        products.setProductsDescription(updateproducts.getProductsDescription());
        products.setProductsPrice(updateproducts.getProductsPrice());
        products.setProductsStockQuanity(updateproducts.getProductsStockQuanity());
        session.merge(products);
        session.getTransaction().commit();
    }

    public void updateReviews(long id,Reviews updatereviews){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Reviews reviews = session.get(Reviews.class, id);
        reviews.setReviewsRating(updatereviews.getReviewsRating());
        reviews.setReviewsComment(updatereviews.getReviewsComment());
        reviews.setReviewsReviewDate(updatereviews.getReviewsReviewDate());
        session.merge(reviews);
        session.getTransaction().commit();
    }

    public void updateUsers(long id,Users updatereusers){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Users users = session.get(Users.class, id);
        users.setUserName(updatereusers.getUserName());
        users.setUserPasswordHash(updatereusers.getUserPasswordHash());
        users.setUserEmail(updatereusers.getUserEmail());
        users.setUserFirstName(updatereusers.getUserFirstName());
        users.setUserLastName(updatereusers.getUserLastName());
        users.setUserPassword(updatereusers.getUserPassword());
        session.merge(users);
        session.getTransaction().commit();
    }

    public String newUsersToDatabase(Users users){
        session = sessionFactory.openSession();
        session.beginTransaction();
        String name  = users.getUserName();

        Query query = (Query) session
                .createQuery("FROM Users WHERE userName = :userName")
                .setParameter("userName", name);
        Users usersFrom = (Users) query.uniqueResult();

        if (usersFrom != null) {
            session.getTransaction().rollback();
            session.close();
            return "Пользователь уже существует с таким именем";
        }
        session.persist(users);
        session.getTransaction().commit();
        session.close();
        return "Пользователь успешно добавлен";
    }

    public Users getUsersFromDatabaseByUserName(String mail){
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        Query<Users> query = (Query)
                session.createQuery("FROM Users WHERE userEmail = :userEmail")
                .setParameter("userEmail", mail);
        Users users = query.uniqueResult();
        if(users == null){
            return null;
        }
        return users;

    }

    public boolean existsUsersByUserEmail(String mail){
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        try {
            Query<Users> query = (Query) session
                    .createQuery("FROM Users WHERE userEmail = :mail", Users.class)
                    .setParameter("mail", mail);
            Users users = query.uniqueResult();
            if (users == null) {
                return false;
            }
            return true;
        }  finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
