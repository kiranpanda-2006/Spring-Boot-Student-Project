package com.kiran.DTO.login;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UpdateLoginDTO {

    @NotBlank
    @Size(min=8, message = "password length must be 8 characters.")
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
