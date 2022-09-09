package com.tutorial.sultana.controllers.impl;

import com.tutorial.sultana.controllers.AuthenticationController;
import com.tutorial.sultana.moduls.auth.AuthResponse;
import com.tutorial.sultana.moduls.auth.LoginPostBody;
import com.tutorial.sultana.moduls.auth.RegistrationPostBody;
import com.tutorial.sultana.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationControllerImpl implements AuthenticationController {

    private final AuthService authService;

    @Override
    public ResponseEntity<AuthResponse> registration(RegistrationPostBody registrationPostBody) {
        return ResponseEntity.ok(authService.registration(registrationPostBody));
    }

    @Override
    public ResponseEntity<AuthResponse> login(LoginPostBody loginPostBody) {
        return ResponseEntity.ok(authService.login(loginPostBody));
    }
}
