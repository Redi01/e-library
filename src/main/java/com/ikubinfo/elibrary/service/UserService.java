package com.ikubinfo.elibrary.service;
import com.ikubinfo.elibrary.domain.dto.user.UserDTO;
import com.ikubinfo.elibrary.domain.entity.User;


import java.util.List;


public interface UserService {
    User findById(Long id);
    UserDTO registerUser(UserDTO userDTO,String userRole);
    List<UserDTO> findAll();
    UserDTO updateUser(Long userId, UserDTO userDTO);
    Void deleteUser(Long id);
}
