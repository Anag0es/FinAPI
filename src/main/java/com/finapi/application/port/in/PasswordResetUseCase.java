package com.finapi.application.port.in;

import com.finapi.domain.model.User;
import java.util.UUID;

public interface PasswordResetUseCase {
    void requestPasswordReset(UUID userId);
    User confirmPasswordReset(UUID userId, String token, String newPassword);
}