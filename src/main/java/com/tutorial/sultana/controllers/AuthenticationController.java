package com.tutorial.sultana.controllers;

import com.tutorial.sultana.moduls.auth.AuthResponse;
import com.tutorial.sultana.moduls.auth.LoginPostBody;
import com.tutorial.sultana.moduls.auth.RegistrationPostBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("auth/")
public interface AuthenticationController {
    @PostMapping("register")
    ResponseEntity<AuthResponse> registration(@RequestBody RegistrationPostBody registrationPostBody);
    @PostMapping("login")
    ResponseEntity<AuthResponse> login(@RequestBody LoginPostBody loginPostBody);

}
