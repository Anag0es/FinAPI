package com.finapi.application.service;

import com.finapi.application.dto.LoginDTO;
import com.finapi.application.dto.LoginResponseDTO;
import com.finapi.application.exception.ApiException;
import com.finapi.domain.model.User;
import com.finapi.domain.repository.UserRepository;
import com.finapi.infra.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public LoginResponseDTO login(LoginDTO loginRequest) {
        Optional<User> userOptional = Optional.ofNullable(userRepository.findByEmail(loginRequest.getEmail()));
        if (userOptional.isEmpty()) {
            throw new ApiException("Usuário não encontrado", HttpStatus.NOT_FOUND);
        }
        User user = userOptional.get();
        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new ApiException("Senha inválida", HttpStatus.BAD_REQUEST);
        }
        // Gera o token JWT com os dados do usuário
        String token = jwtUtil.generateToken(user);
        return new LoginResponseDTO(token);
    }
}
