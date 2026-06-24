package com.dpcs.dto;

import jakarta.validation.constraints.*;

public class RegisterRequest {

    @NotBlank
    private String fullName;

    @Email
    private String email;

    @Size(min = 6)
    private String password;

    @Pattern(regexp = "^[0-9]{10}$")
    private String phone;

    // getters setters
}