package com.ikubinfo.elibrary.service;

import com.ikubinfo.elibrary.domain.dto.user.UserDTO;
import com.ikubinfo.elibrary.domain.dto.user.UserUpdateDTO;
import com.ikubinfo.elibrary.domain.entity.User;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.List;


public interface UserService {
    User findById(Long id);
    UserDTO registerUser(UserDTO userDTO);
    UserUpdateDTO updateUser(Long id, UserUpdateDTO req);
    User getUserFromToken(Jwt jwt);
    List<UserDTO> findAll();

    UserDTO updateUser(Long userId, UserDTO userDTO);
}
