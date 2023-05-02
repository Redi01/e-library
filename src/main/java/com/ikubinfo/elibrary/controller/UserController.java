package com.ikubinfo.elibrary.controller;

import com.ikubinfo.elibrary.domain.dto.user.UserDTO;
import com.ikubinfo.elibrary.domain.dto.user.UserUpdateDTO;
import com.ikubinfo.elibrary.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        UserDTO u = userService.registerUser(userDTO);
        return ResponseEntity.ok(u);
    }

    @PostMapping("/updateUser/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id,@RequestBody UserDTO userDTO){
        UserDTO u = userService.updateUser(id, userDTO);
        return ResponseEntity.ok(u);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserDTO>> getAll(){
        List<UserDTO> u = userService.findAll();
        return ResponseEntity.ok(u);
    }
}

