package com.finapi.application.port.in.tag;

import com.finapi.domain.model.Tag;

import java.util.List;
import java.util.UUID;

public interface GetTagUseCase {
    List<Tag> getTags();

    Tag getTagById(UUID id);

    List<Tag> getTagsForUser(UUID userId);
}
