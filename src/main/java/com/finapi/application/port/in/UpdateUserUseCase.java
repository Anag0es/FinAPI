package com.finapi.application.port.in;

import com.finapi.domain.model.User;
import java.util.UUID;

public interface UpdateUserUseCase {
    User updateName(UUID userId, String name);
}
