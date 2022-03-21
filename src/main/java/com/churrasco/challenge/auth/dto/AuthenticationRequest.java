package com.churrasco.challenge.auth.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationRequest {

    private String usernameOrEmail;
    private String password;

}
