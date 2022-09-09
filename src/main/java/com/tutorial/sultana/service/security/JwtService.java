package com.tutorial.sultana.service.security;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.function.Function;

public interface JwtService {

    public String getUsernameFromToken(String token);

    String getAuthority(String token);

    Date getIssuedAtDateFromToken(String token);

    Date getExpirationDateFromToken(String token);

    <T> T getClaimFromToken(String token, Function<Claims, T> claimResolver);

    String generateToken(Authentication authentication);

    String refreshToken(String token);

    boolean validateToken(String token, UserDetails userDetails);

    String parseBarerToken(String barerToken);
}
