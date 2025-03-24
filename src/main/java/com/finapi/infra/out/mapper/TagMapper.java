package com.finapi.infra.out.mapper;

import com.finapi.application.dto.response.ResponseTagDTO;
import com.finapi.domain.model.Tag;
import com.finapi.infra.out.entity.TagEntity;

import java.util.List;
import java.util.stream.Collectors;

public class TagMapper {

    public static Tag toDomain(TagEntity tagEntity) {
        if (tagEntity == null) {
            return null;
        }

        return new Tag(
                tagEntity.getId(),
                UserMapper.toDomain(tagEntity.getUser()),
                tagEntity.getName(),
                tagEntity.isDefault(),
                tagEntity.getCreatedAt(),
                tagEntity.getUpdatedAt()
        );
    }

    public static TagEntity toEntity(Tag tag) {
        if (tag == null) {
            return null;
        }

        return new TagEntity(
                tag.getId(),
                tag.getUser() != null ? UserMapper.toEntity(tag.getUser()) : null,
                tag.getName(),
                tag.isDefault(),
                tag.getCreatedAt(),
                tag.getUpdatedAt()
        );
    }

    public static ResponseTagDTO toDTO(Tag tag) {
        if (tag == null) return null;

        return new ResponseTagDTO(
                tag.getId(),
                tag.getName(),
                tag.isDefault(),
                tag.getUser() != null ? tag.getUser().getId() : null,
                tag.getCreatedAt(),
                tag.getUpdatedAt()
        );
    }

    public static List<ResponseTagDTO> toDTOList(List<Tag> tags) {
        return tags.stream()
                .map(TagMapper::toDTO)
                .collect(Collectors.toList());
    }
}
