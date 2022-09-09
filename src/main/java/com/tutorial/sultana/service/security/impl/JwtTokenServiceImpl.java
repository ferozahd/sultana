package com.tutorial.sultana.service.security.impl;

import com.tutorial.sultana.service.security.JwtService;
import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.DefaultClock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Slf4j
public class JwtTokenServiceImpl implements JwtService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    private Clock clock = DefaultClock.INSTANCE;


    private static final String RESTAURANT_ID = "restaurantId";
    private static final String TABLE_ID = "tableId";
    private static final String STATUS = "status";

    @Override
    public String getUsernameFromToken(String token) {
        try {
            return getClaimFromToken(token, Claims::getSubject);
        } catch (ExpiredJwtException e) {
            return e.getClaims().getSubject();
        }
    }

    @Override
    public String getAuthority(String token) {
        try {
            final Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
            return (String) claims.get("authorities");
        }catch (ExpiredJwtException e){
            return e.getClaims().getId();
        }

    }

    @Override
    public Date getIssuedAtDateFromToken(String token) {
        try {
            return getClaimFromToken(token, Claims::getIssuedAt);
        } catch (ExpiredJwtException e) {
            return e.getClaims().getIssuedAt();
        }
    }

    @Override
    public Date getExpirationDateFromToken(String token) {
        try {
            return getClaimFromToken(token, Claims::getExpiration);
        } catch (ExpiredJwtException e) {
            return e.getClaims().getExpiration();
        }
    }

    @Override
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        return claimsResolver.apply(claims);
    }

    @Override
    public String generateToken(Authentication authentication) {
        // getting authorities joined by comma
        String authorities =
            authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        final Date createdDate = clock.now();
        final Date expirationDate = calculateExpirationDate(createdDate);



        RootUserDetails user =
            (RootUserDetails) authentication.getPrincipal();

        Map<String, Object> claims = new HashMap<>();
        String subject = null;

//        // set CompanyId
//        if (!StringUtils.isEmpty(user.getAuthorities())) {
//            claims.put("comapyId", user.getAuthorities());
//        }

        claims.put("authorities", authorities);


        return Jwts.builder()
            .setSubject(user.getUsername().toString())
            .addClaims(claims)
            .signWith(SignatureAlgorithm.HS512, secret)
            .setExpiration(expirationDate)
            .setIssuedAt(createdDate)
            .compact();
    }


    @Override
    public String refreshToken(String token) {
        final Date createdDate = clock.now();
        final Date expirationDate = calculateExpirationDate(createdDate);

        final Claims claims = getAllClaimsFromToken(token);
        claims.setIssuedAt(createdDate);
        claims.setExpiration(expirationDate);

        return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    @Override
    public boolean validateToken(String token, UserDetails userDetails) {
             final String username = getUsernameFromToken(token);
            final Date created = getIssuedAtDateFromToken(token);

            try {
                Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
                if (username.equals(userDetails.getUsername()) && !isTokenExpired(token)) {
                    return true;
                }
                return false;
            } catch (SignatureException ex) {
                log.error("Invalid JWT signature");
            } catch (MalformedJwtException ex) {
                log.error("Invalid JWT token");
            } catch (ExpiredJwtException ex) {
                log.error("Expired JWT token");
            } catch (UnsupportedJwtException ex) {
                log.error("Unsupported JWT token");
            } catch (IllegalArgumentException ex) {
                log.error("JWT claims string is empty.");
            }

            return false;


    }

    @Override
    public String parseBearerToken(String bearerToken) {
        return bearerToken.replace("Bearer", "").trim();
    }


    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(clock.now());
    }

    private Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset) {
        return (lastPasswordReset != null && created.before(lastPasswordReset));
    }

    private Boolean ignoreTokenExpiration(String token) {
        // here you specify tokens, for that the expiration is ignored
        return false;
    }

    private Date calculateExpirationDate(Date createdDate) {
        return new Date(createdDate.getTime() + expiration * 1000);
    }

    private Date calculateExpirationDate(Date createdDate, long expiration) {
        return new Date(createdDate.getTime() + expiration * 1000);
    }

}
