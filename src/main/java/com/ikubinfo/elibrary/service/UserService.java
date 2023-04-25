package com.ikubinfo.elibrary.service;

import com.ikubinfo.elibrary.domain.dto.user.UserDTO;
import com.ikubinfo.elibrary.domain.dto.user.UserUpdateDTO;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.jwt.Jwt;


public interface UserService {
    com.ikubinfo.elibrary.domain.entity.User findById(Long id);
    UserDTO registerUser(UserDTO req, String userRole);
    UserUpdateDTO updateUser(Integer id, UserUpdateDTO req);
    User getUserFromToken(Jwt jwt);
}
