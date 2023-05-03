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
        String email = userDTO.getEmail();
        if (userRepository.findByEmail(email).isPresent()) {
            throw new ResourceNotFoundException("A user with this email address already exists");
        }

        User user = UserMapper.toEntity(userDTO);

        String username = createUniqueUsername(email);
        user.setUsername(username);
        String encodedPassword = passwordEncoder.encode(userDTO.getPassword());
        user.setPassword(encodedPassword);

        user = userRepository.save(user);

        return UserMapper.toDto(user);
    }

    private String createUniqueUsername(String email) {

        String username = email.replaceAll("^([^@]+).*$", "$1");

        username = username.toLowerCase().replaceAll("[^a-z0-9]", "");

        String baseUsername = username;
        int suffix = 1;
        while (userRepository.findByUsername(username).isPresent()) {
            username = baseUsername + suffix;
            suffix++;
        }

        return username;
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

    @Override
    public Void deleteUser(Long id) {
        userRepository.findById(id)
                .ifPresentOrElse(u->userRepository.deleteById(id),()-> new ResourceNotFoundException(
                        String.format("User with id %s not found",id)
                ));
        return null;
    }


}

