package com.finapi.application.port.in;

import com.finapi.domain.model.User;
import java.util.UUID;

public interface EmailChangeUseCase {
    void requestEmailChange(UUID userId, String newEmail);
    User confirmEmailChange(UUID userId, String token);
}