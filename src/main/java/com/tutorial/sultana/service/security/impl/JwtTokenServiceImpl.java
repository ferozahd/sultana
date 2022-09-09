package com.tutorial.sultana.service.security.impl;

import com.tutorial.sultana.service.security.JwtService;
import io.jsonwebtoken.Claims;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.function.Function;

public class JwtTokenServiceImpl implements JwtService {
    @Override
    public String getUsernameFromToken(String token) {
        return null;
    }

    @Override
    public String getAuthority(String token) {
        return null;
    }

    @Override
    public Date getIssuedAtDateFromToken(String token) {
        return null;
    }

    @Override
    public Date getExpirationDateFromToken(String token) {
        return null;
    }

    @Override
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimResolver) {
        return null;
    }

    @Override
    public String generateToken(Authentication authentication) {
        return null;
    }

    @Override
    public String refreshToken(String token) {
        return null;
    }

    @Override
    public boolean validateToken(String token, UserDetails userDetails) {
        return false;
    }

    @Override
    public String parseBarerToken(String barerToken) {
        return null;
    }
}
