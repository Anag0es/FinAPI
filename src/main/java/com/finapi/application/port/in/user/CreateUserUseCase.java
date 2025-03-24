package com.finapi.application.port.in.user;

import com.finapi.application.dto.request.CreateUserDTO;
import com.finapi.domain.model.User;

public interface CreateUserUseCase {
    User createUser(CreateUserDTO createUserDTO);
}
