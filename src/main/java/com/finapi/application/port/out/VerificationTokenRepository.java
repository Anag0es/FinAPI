package com.finapi.application.port.out;

import com.finapi.domain.model.VerificationToken;

public interface VerificationTokenRepository {
    void save(VerificationToken verificationToken);

    VerificationToken findByToken(String token);
}
