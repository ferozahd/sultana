package com.tutorial.sultana.config.filter;

import com.tutorial.sultana.service.security.JwtService;
import com.tutorial.sultana.service.security.UserServiceDetails;
import com.tutorial.sultana.service.security.impl.RootUserDetails;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private static final String TOKEN = "token";
    private static final String BEARER = "Bearer ";

    private final UserServiceDetails customerDetailsService;


    @Override
    protected void doFilterInternal(
        HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
        FilterChain filterChain) throws ServletException, IOException {

        String requestHeader = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);

        if (requestHeader == null) {
            String token = httpServletRequest.getParameter(TOKEN);
            if (token != null) {
                requestHeader = BEARER + token;
            }
        }
        String username = null;
        String authToken = null;
        String authority = null;
        if (requestHeader != null && requestHeader.startsWith("Bearer ")) {
            authToken = jwtService.parseBearerToken(requestHeader);

            try {
                username = jwtService.getUsernameFromToken(authToken);
                authority = jwtService.getAuthority(authToken);
            } catch (IllegalArgumentException e) {
                log.error("an error occurred during getting username from token", e);
            } catch (ExpiredJwtException e) {
                log.warn("the token is expired and not valid anymore", e);
            }
 if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

                logger.debug("security context was null, so authorizing user");

                RootUserDetails userDetails = (RootUserDetails) this.customerDetailsService.loadUserByUsername(username);


                if (jwtService.validateToken(authToken, userDetails)) {
                    UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }

        }
       filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
