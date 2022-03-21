package com.churrasco.challenge.auth.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserDTO {

    @NotBlank(message = "Email must not be blank")
    @Email(message = "Email must be a well-formed email address")
    private String email;
    @NotBlank(message = "First name must not be blank")
    private String firstname;
    @NotBlank(message = "Last name must not be blank")
    private String lastname;
    @NotBlank(message = "Password must not be blank")
    @Size(min = 8, message = "Password must have at least eight characters")
    private String password;
    @NotBlank(message = "Username must not be blank")
    private String username;

}
