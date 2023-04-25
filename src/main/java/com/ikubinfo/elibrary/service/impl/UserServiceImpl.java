package com.ikubinfo.elibrary.service.impl;

import com.ikubinfo.elibrary.domain.dto.user.UserDTO;
import com.ikubinfo.elibrary.domain.dto.user.UserUpdateDTO;
import com.ikubinfo.elibrary.domain.exception.ResourceNotFoundException;
import com.ikubinfo.elibrary.repository.UserRepository;
import com.ikubinfo.elibrary.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;



    @Override
    public com.ikubinfo.elibrary.domain.entity.User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(String
                        .format("User with id %s not found",id)));
    }

    @Override
    public UserDTO registerUser(UserDTO req, String userRole) {
        return null;
    }

    @Override
    public UserUpdateDTO updateUser(Integer id, UserUpdateDTO req) {
        return null;
    }

    @Override
    public User getUserFromToken(Jwt jwt) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}

