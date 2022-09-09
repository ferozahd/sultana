package com.tutorial.sultana.service.impl;

import com.tutorial.sultana.entities.User;
import com.tutorial.sultana.exceptions.DataAlreadyExistException;
import com.tutorial.sultana.moduls.auth.AuthResponse;
import com.tutorial.sultana.moduls.auth.LoginPostBody;
import com.tutorial.sultana.moduls.auth.RegistrationPostBody;
import com.tutorial.sultana.repo.UserRepository;
import com.tutorial.sultana.service.AuthService;
import com.tutorial.sultana.service.security.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    @Override
    public AuthResponse registration(RegistrationPostBody registrationPostBody) {
        User user = new User();
        user.setUserName(registrationPostBody.getUsername());
        user.setPassword(passwordEncoder.encode(registrationPostBody.getPassword()));
        user.setEmail(registrationPostBody.getEmail());
        long userCount = userRepository.countByUserName(registrationPostBody.getUsername());
        long emailCount = userRepository.countByEmail(registrationPostBody.getEmail());
        if (userCount > 0) {
            throw new DataAlreadyExistException("user already exists");
        }
        if (emailCount > 0) {
            throw new DataAlreadyExistException("Email already exists ");
        }
        userRepository.save(user);
        return null;
    }

    @Override
    public AuthResponse login(LoginPostBody loginPostBody) {
        Authentication authentication =
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginPostBody.getUsername(), loginPostBody.getPassword())
            );
        String token=jwtService.generateToken(authentication);
        return new AuthResponse(token);
    }
}
