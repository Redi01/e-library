package com.ikubinfo.elibrary.service.impl;

import com.ikubinfo.elibrary.domain.dto.user.UserDTO;
import com.ikubinfo.elibrary.domain.dto.user.UserUpdateDTO;
import com.ikubinfo.elibrary.domain.entity.User;
import com.ikubinfo.elibrary.domain.exception.ResourceNotFoundException;
import com.ikubinfo.elibrary.domain.mapper.UserMapper;
import com.ikubinfo.elibrary.repository.UserRepository;
import com.ikubinfo.elibrary.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public com.ikubinfo.elibrary.domain.entity.User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(String
                        .format("User with id %s not found",id)));
    }

    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        User user = UserMapper.toEntity(userDTO);
        userRepository.save(user);
        return userDTO;
    }

    @Override
    public UserUpdateDTO updateUser(Long id, UserUpdateDTO req) {
        return null;
    }

    @Override
    public User getUserFromToken(Jwt jwt) {
        return null;
    }

    @Override
    public List<UserDTO> findAll() {
        List<User> users = userRepository.findAll();
        return UserMapper.toDtos(users);
    }

    @Override
    public UserDTO updateUser(Long userId, UserDTO userDTO) {
        Optional<User> user = userRepository.findById(userId);
        user = Optional.ofNullable(UserMapper.buildUpdateUser(user.get(), userDTO));
        userRepository.save(user.get());
        return userDTO;
    }

}

