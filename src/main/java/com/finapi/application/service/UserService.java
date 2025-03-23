package com.finapi.application.service;

import com.finapi.application.dto.CreateUserDTO;
import com.finapi.application.exception.ApiException;
import com.finapi.domain.enums.Roles;
import com.finapi.domain.enums.Status;
import com.finapi.domain.model.User;
import com.finapi.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public User createUser(CreateUserDTO createUserDTO) {
        if(userRepository.findByEmail(createUserDTO.getEmail()) != null) {
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
        if(user == null) {
            throw new ApiException("Usuário não encontrado", HttpStatus.NOT_FOUND);
        }

        return user;
    }

}
