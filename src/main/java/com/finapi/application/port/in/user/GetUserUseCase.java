package com.finapi.application.port.in.user;

import com.finapi.domain.model.User;
import java.util.List;
import java.util.UUID;

public interface GetUserUseCase {
    User getUserById(UUID id);
    User getUserByEmail(String email);
    List<User> getUsers();
}