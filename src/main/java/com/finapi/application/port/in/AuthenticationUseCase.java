package com.finapi.application.port.in;

import java.util.UUID;

public interface AuthenticationUseCase {
    String login(String email, String password);
    UUID getCurrentUserId(String token);
}
