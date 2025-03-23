package com.finapi.infra.in.controller;

import com.finapi.application.dto.CreateUserDTO;
import com.finapi.application.service.UserService;
import com.finapi.config.RequiresAuthentication;
import com.finapi.domain.model.User;
import com.finapi.infra.security.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping
    public User createUser(@RequestBody CreateUserDTO createUserDTO) {
        return userService.createUser(createUserDTO);
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/user")
    @RequiresAuthentication
    public User getCurrentUser(HttpServletRequest request) {
        String token = request.getHeader("Authorization").substring(7);
        UUID userId = jwtUtil.getUserIdFromToken(token);
        return userService.getUserById(userId);
    }

}
