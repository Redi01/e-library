package com.ikubinfo.elibrary.service.impl;

import com.ikubinfo.elibrary.domain.dto.user.UserDTO;
import com.ikubinfo.elibrary.domain.entity.User;
import com.ikubinfo.elibrary.domain.exception.ResourceNotFoundException;
import com.ikubinfo.elibrary.domain.mapper.UserMapper;
import com.ikubinfo.elibrary.repository.UserRepository;
import com.ikubinfo.elibrary.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public com.ikubinfo.elibrary.domain.entity.User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String
                        .format("User with id %s not found", id)));
    }

    @Transactional
    @Override
    public UserDTO registerUser(UserDTO userDTO, String userRole) {

        Optional<User> doesUserExist = userRepository.findByEmail(userDTO.getEmail());
        if (!doesUserExist.isPresent()){
            User u = UserMapper.toEntity(userDTO);
            u.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            u = userRepository.save(u);
            return UserMapper.toDto(u);
        } else {
            throw new ResourceNotFoundException("A user with this email address already exists");
        }
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
                .ifPresentOrElse(u -> userRepository.deleteById(id), () -> new ResourceNotFoundException(
                        String.format("User with id %s not found", id)
                ));
        return null;
    }


}

