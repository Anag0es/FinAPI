package com.finapi.application.port.in.tag;

import java.util.UUID;

public interface DeleteTagUseCase {
    void deleteTagById(UUID id);
}
