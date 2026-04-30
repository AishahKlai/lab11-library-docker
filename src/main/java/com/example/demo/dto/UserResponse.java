package com.example.demo.dto;

import lombok.Data;
import lombok.Builder;
@Data
@Builder
public class UserResponse {
    private Long id;
    private String fullName;
    private String email;
    private String phone;
    private String address;

}
