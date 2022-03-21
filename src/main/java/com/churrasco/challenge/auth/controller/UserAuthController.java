package com.churrasco.challenge.auth.controller;

import com.churrasco.challenge.auth.dto.AuthenticationRequest;
import com.churrasco.challenge.auth.dto.AuthenticationResponse;
import com.churrasco.challenge.auth.dto.UserDTO;
import com.churrasco.challenge.auth.service.UserDetailsCustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class UserAuthController {

    @Autowired
    private UserDetailsCustomService userDetailsCustomService;

    @PostMapping("/signup")
    public ResponseEntity<AuthenticationResponse> signUp(@Valid @RequestBody UserDTO dto) throws Exception {
        userDetailsCustomService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/signin")
    public ResponseEntity<AuthenticationResponse> signIn(@RequestBody AuthenticationRequest authReq) throws Exception {
        final String jwt = userDetailsCustomService.signIn(authReq);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

}
