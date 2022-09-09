package com.tutorial.sultana.service.security.impl;

import com.tutorial.sultana.entities.User;
import com.tutorial.sultana.exceptions.ResourceNotFoundException;
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
        User user = userRepository.findByUserName(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return new RootUserDetails(user);
    }
}

