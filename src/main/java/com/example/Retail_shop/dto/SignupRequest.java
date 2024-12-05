package com.example.Retail_shop.dto;

import lombok.Data;
@Data
public class SignupRequest {
    private String userName;
    private String userPasswordHash;
    private String userEmail;
    private String userFirstName;
    private String userLastName;
    private String userPassword;
}
