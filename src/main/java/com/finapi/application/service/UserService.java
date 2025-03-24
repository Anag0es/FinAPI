package com.finapi.application.service;

import com.finapi.application.dto.request.CreateUserDTO;
import com.finapi.application.exception.ApiException;
import com.finapi.application.port.in.*;
import com.finapi.application.port.in.user.CreateUserUseCase;
import com.finapi.application.port.in.user.GetUserUseCase;
import com.finapi.application.port.in.user.UpdateUserUseCase;
import com.finapi.application.port.out.UserRepository;
import com.finapi.application.port.out.VerificationTokenRepository;
import com.finapi.domain.enums.Roles;
import com.finapi.domain.enums.Status;
import com.finapi.domain.model.User;
import com.finapi.domain.model.VerificationToken;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.UUID;


@Service
public class UserService implements UpdateUserUseCase, GetUserUseCase, CreateUserUseCase,
        EmailChangeUseCase, PasswordResetUseCase {

    private final UserRepository userRepository;
    private final EmailService emailService;
    private final PasswordEncoder passwordEncoder;
    private final VerificationTokenRepository tokenRepository;

    public UserService(UserRepository userRepository,
                       EmailService emailService,
                       PasswordEncoder passwordEncoder,
                       VerificationTokenRepository tokenRepository) {
        this.userRepository = userRepository;
        this.emailService = emailService;
        this.passwordEncoder = passwordEncoder;
        this.tokenRepository = tokenRepository;
    }

    @Override
    public User createUser(CreateUserDTO createUserDTO) {
        if (userRepository.findByEmail(createUserDTO.getEmail()) != null) {
            throw new ApiException("Email já cadastrado", HttpStatus.BAD_REQUEST);
        }

        User user = new User();
        user.setName(createUserDTO.getName());
        user.setEmail(createUserDTO.getEmail());
        user.setPassword(passwordEncoder.encode(createUserDTO.getPassword()));
        user.setRole(Roles.USER);
        user.setStatus(Status.ACTIVE);
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(UUID id) {
        User user = userRepository.findById(id);
        if (user == null) {
            throw new ApiException("Usuário não encontrado", HttpStatus.NOT_FOUND);
        }

        return user;
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    public User updateName(UUID userId, String name) {
        User userToUpdate = userRepository.findById(userId);
        if (userToUpdate == null) {
            throw new ApiException("Usuário não encontrado", HttpStatus.NOT_FOUND);
        }

        userToUpdate.setName(name);
        userToUpdate.setUpdatedAt(LocalDateTime.now());

        return userRepository.update(userToUpdate);
    }

    public void requestEmailChange(UUID userId, String newEmail) {
        User user = userRepository.findById(userId);
        if (user == null) {
            throw new ApiException("Usuário não encontrado", HttpStatus.NOT_FOUND);
        }

        if (userRepository.findByEmail(newEmail) != null) {
            throw new ApiException("Email já cadastrado", HttpStatus.BAD_REQUEST);
        }

        String token = generateRandomToken();

        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setUserId(userId);
        verificationToken.setToken(token);
        verificationToken.setTokenType("EMAIL_CHANGE");
        verificationToken.setNewValue(newEmail);
        verificationToken.setExpiryDate(LocalDateTime.now().plusHours(24));
        verificationToken.setUsed(false);

        tokenRepository.save(verificationToken);

        String subject = "Confirmação de alteração de email";
        String message = "Seu código de confirmação para alteração de email é: " + token;
        emailService.sendSimpleMessage(user.getEmail(), subject, message);
    }

    public User confirmEmailChange(UUID userId, String token) {
        VerificationToken verificationToken = tokenRepository.findByToken(token);

        if (verificationToken == null ||
                !verificationToken.getUserId().equals(userId) ||
                verificationToken.isUsed() ||
                verificationToken.getExpiryDate().isBefore(LocalDateTime.now()) ||
                !"EMAIL_CHANGE".equals(verificationToken.getTokenType())) {
            throw new ApiException("Token inválido ou expirado", HttpStatus.BAD_REQUEST);
        }

        User user = userRepository.findById(userId);
        user.setEmail(verificationToken.getNewValue());
        user.setUpdatedAt(LocalDateTime.now());

        verificationToken.setUsed(true);
        tokenRepository.save(verificationToken);

        return userRepository.update(user);
    }

    public void requestPasswordReset(UUID userId) {
        User user = userRepository.findById(userId);
        if (user == null) {
            throw new ApiException("Usuário não encontrado", HttpStatus.NOT_FOUND);
        }

        String token = generateRandomToken();

        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setUserId(userId);
        verificationToken.setToken(token);
        verificationToken.setTokenType("PASSWORD_RESET");
        verificationToken.setExpiryDate(LocalDateTime.now().plusHours(24));
        verificationToken.setUsed(false);

        tokenRepository.save(verificationToken);

        String subject = "Redefinição de senha";
        String message = "Seu código de confirmação para redefinição de senha é: " + token;
        emailService.sendSimpleMessage(user.getEmail(), subject, message);
    }

    public User confirmPasswordReset(UUID userId, String token, String newPassword) {
        VerificationToken verificationToken = tokenRepository.findByToken(token);

        if (verificationToken == null ||
                !verificationToken.getUserId().equals(userId) ||
                verificationToken.isUsed() ||
                verificationToken.getExpiryDate().isBefore(LocalDateTime.now()) ||
                !"PASSWORD_RESET".equals(verificationToken.getTokenType())) {
            throw new ApiException("Token inválido ou expirado", HttpStatus.BAD_REQUEST);
        }

        User user = userRepository.findById(userId);
        user.setPassword(passwordEncoder.encode(newPassword));
        user.setUpdatedAt(LocalDateTime.now());

        // Mark token as used
        verificationToken.setUsed(true);
        tokenRepository.save(verificationToken);

        return userRepository.update(user);
    }

    private String generateRandomToken() {
        Random random = new Random();
        int number = random.nextInt(999999);
        return String.format("%06d", number);
    }

}
