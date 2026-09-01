package com.app.ecom.dto;

import lombok.Data;
import com.app.ecom.model.Address;

@Data
public class UserRequest{ 
    private String fname;
    private String lname;
    private String email;
    private String phone;
    private Address address;
}