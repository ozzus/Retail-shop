package com.example.Retail_shop.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Retail_shop.models.Users;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByUserName(String userName);
    Boolean existsByUserName(String userName);
    Boolean existsByUserEmail(String userEmail);
}
