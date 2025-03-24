package com.finapi.infra.in.web;

import com.finapi.application.dto.request.CreateUserDTO;
import com.finapi.application.dto.request.UpdatePasswordDTO;
import com.finapi.application.dto.request.VerifyTokenDTO;
import com.finapi.application.service.UserService;
import com.finapi.config.RequiresAuthentication;
import com.finapi.domain.model.User;
import com.finapi.infra.security.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    public UserController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

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

    @PutMapping("/name")
    @RequiresAuthentication
    public User updateUserName(@RequestBody Map<String, String> payload, HttpServletRequest request) {
        String token = request.getHeader("Authorization").substring(7);
        UUID userId = jwtUtil.getUserIdFromToken(token);
        return userService.updateName(userId, payload.get("name"));
    }

    @PostMapping("/request-email-change")
    @RequiresAuthentication
    public ResponseEntity<?> requestEmailChange(@RequestBody Map<String, String> payload, HttpServletRequest request) {
        String token = request.getHeader("Authorization").substring(7);
        UUID userId = jwtUtil.getUserIdFromToken(token);
        userService.requestEmailChange(userId, payload.get("newEmail"));
        return ResponseEntity.ok().body(Map.of("message", "Verification token sent to your email"));
    }

    @PostMapping("/confirm-email-change")
    @RequiresAuthentication
    public User confirmEmailChange(@RequestBody VerifyTokenDTO payload, HttpServletRequest request) {
        String token = request.getHeader("Authorization").substring(7);
        UUID userId = jwtUtil.getUserIdFromToken(token);
        return userService.confirmEmailChange(userId, payload.getToken());
    }

    @PostMapping("/request-password-reset")
    @RequiresAuthentication
    public ResponseEntity<?> requestPasswordReset(HttpServletRequest request) {
        String token = request.getHeader("Authorization").substring(7);
        UUID userId = jwtUtil.getUserIdFromToken(token);
        userService.requestPasswordReset(userId);
        return ResponseEntity.ok().body(Map.of("message", "Password reset token sent to your email"));
    }

    @PostMapping("/confirm-password-reset")
    @RequiresAuthentication
    public User confirmPasswordReset(@RequestBody UpdatePasswordDTO payload, HttpServletRequest request) {
        String token = request.getHeader("Authorization").substring(7);
        UUID userId = jwtUtil.getUserIdFromToken(token);
        return userService.confirmPasswordReset(userId, payload.getToken(), payload.getNewPassword());
    }

}
