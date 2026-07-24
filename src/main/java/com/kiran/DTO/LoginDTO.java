package com.kiran.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginDTO {


    @NotBlank
    @Size(min = 2,max = 20, message ="Name exceeds or lessThen length 2-20" )
    private String  name;
    @NotBlank
    @Email(message = "please give a valid email format.")
    private String email;
    @NotBlank
    @Size(min=8, message = "password length must be 8 characters.")
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
