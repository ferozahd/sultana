package com.tutorial.sultana.service.security.impl;

import com.tutorial.sultana.exceptions.BadCredentialsException;
import com.tutorial.sultana.repo.UserRepository;
import com.tutorial.sultana.service.security.UserServiceDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceDetailsImpl implements UserServiceDetails {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new RootUserDetails(userRepository.findByUserName(username)
            .orElseThrow(() -> new BadCredentialsException("un authorized user"))
        );
    }
}

