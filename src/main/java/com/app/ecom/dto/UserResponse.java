package com.app.ecom.dto;

import lombok.Data;
import com.app.ecom.model.UserRole;

@Data
public class UserResponse{
    private String id;
    private String fname;
    private String lname;
    private String email;
    private String phone;
    private UserRole role;
    private AddressDTO address;
}