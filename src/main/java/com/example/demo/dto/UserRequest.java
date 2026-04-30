package com.example.demo.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRequest {
    @NotBlank(message = "Full name is required")
    @Size(min = 2, max = 100)
    private String fullName;

    @NotBlank(message = "Email name is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Phone name is required")
    private String phone;

    @NotBlank(message = "Address name is required")
    private String address;
}
