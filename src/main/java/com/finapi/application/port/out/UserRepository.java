package com.finapi.application.port.out;

import com.finapi.domain.model.User;

import java.util.List;
import java.util.UUID;

public interface UserRepository {
    User save(User user);

    User findByEmail(String email);

    User findById(UUID id);

    List<User> findAll();

    User update(User userToUpdate);
}