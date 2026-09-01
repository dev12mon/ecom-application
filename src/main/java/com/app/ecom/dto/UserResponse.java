package com.app.ecom.dto

@Data
public class UserResponse{
    private String fname;
    private String lname;
    private String email;
    private String phone;
    private UserRole role;
    private Address address;
}