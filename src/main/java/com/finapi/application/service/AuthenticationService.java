package com.finapi.application.service;

import com.finapi.application.exception.ApiException;
import com.finapi.application.port.in.AuthenticationUseCase;
import com.finapi.application.port.out.UserRepository;
import com.finapi.domain.model.User;
import com.finapi.infra.security.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class AuthenticationService implements AuthenticationUseCase {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationService(UserRepository userRepository, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String login(String email, String password) {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new ApiException("Usuário não encontrado", HttpStatus.NOT_FOUND);
        }

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new ApiException("Senha inválida", HttpStatus.BAD_REQUEST);
        }

        user.setLastLogin(LocalDateTime.now());
        userRepository.update(user);

        return jwtUtil.generateToken(user);
    }

    @Override
    public UUID getCurrentUserId(String token) {
        return jwtUtil.getUserIdFromToken(token);
    }
}
