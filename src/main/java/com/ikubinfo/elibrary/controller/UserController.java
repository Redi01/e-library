package com.ikubinfo.elibrary.controller;

import com.ikubinfo.elibrary.domain.dto.user.UserDTO;
import com.ikubinfo.elibrary.domain.dto.user.UserUpdateDTO;
import com.ikubinfo.elibrary.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @RolesAllowed("ADMIN")
    @PostMapping("/admin/{userRole}")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO req, @PathVariable String userRole){
        UserDTO dto = userService.registerUser(req,userRole);
        return ResponseEntity.ok(dto);
    }

    @RolesAllowed("ADMIN")
    @PutMapping("/admin/{id}")
    public ResponseEntity<UserUpdateDTO> updateUser(@PathVariable Long id, @RequestBody UserUpdateDTO req){
        UserUpdateDTO u = userService.updateUser(id,req);
        return ResponseEntity.ok(u);
    }

    }

