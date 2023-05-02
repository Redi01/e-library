package com.ikubinfo.elibrary.domain.mapper;

import com.ikubinfo.elibrary.domain.dto.user.UserDTO;
import com.ikubinfo.elibrary.domain.dto.user.UserUpdateDTO;
import com.ikubinfo.elibrary.domain.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {
    public static UserDTO toDto(User u){
        return UserDTO.builder()
                .name(u.getName())
                .surname(u.getSurname())
                .email(u.getEmail())
                .role(RoleMapper.toDto(u.getRoleUI()))
                .build();

    }

    public static List<UserDTO> toDtos(List<User> u){
        List<UserDTO> userDTOS = new ArrayList<>();
        for (User user:u) {
            UserDTO userDTO = toDto(user);
            userDTOS.add(userDTO);
        }
        return userDTOS;
    }
    public static User toEntity(UserDTO u){
        return User.builder()
                .name(u.getName())
                .surname(u.getSurname())
                .email(u.getEmail())
                .password(u.getPassword())
                .roleUI(RoleMapper.toEntity(u.getRole()))
                .build();
    }
    public static UserUpdateDTO toUpdateDto(User u){
        return UserUpdateDTO.builder()
                .id(u.getId())
                .name(u.getName())
                .surname(u.getSurname())
                .email(u.getEmail())
                .build();
    }
    public static User buildUpdateUser(User u,UserDTO req){
        u.setName(req.getName());
        u.setSurname(req.getSurname());
        u.setEmail(req.getEmail());
        u.setRoleUI(RoleMapper.buildUpdateUserRole(u.getRoleUI(), req.getRole()));
        return u;
    }
}
