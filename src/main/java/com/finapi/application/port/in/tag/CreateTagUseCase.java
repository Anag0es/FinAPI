package com.finapi.application.port.in.tag;

import com.finapi.application.dto.request.CreateTagDTO;
import com.finapi.domain.model.Tag;

public interface CreateTagUseCase {
    Tag createTag(CreateTagDTO createTagDTO);
}
