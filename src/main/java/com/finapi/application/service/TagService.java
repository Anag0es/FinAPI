package com.finapi.application.service;

import com.finapi.application.dto.request.CreateTagDTO;
import com.finapi.application.exception.ApiException;
import com.finapi.application.port.in.tag.CreateTagUseCase;
import com.finapi.application.port.in.tag.DeleteTagUseCase;
import com.finapi.application.port.in.tag.GetTagUseCase;
import com.finapi.application.port.out.TagRepository;
import com.finapi.domain.model.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class TagService implements CreateTagUseCase, GetTagUseCase, DeleteTagUseCase {

    private final TagRepository tagRepository;
    private final UserService userService;

    public TagService(TagRepository tagRepository, UserService userService) {
        this.tagRepository = tagRepository;
        this.userService = userService;
    }

    @Override
    public Tag createTag(CreateTagDTO createTagDTO) {

        if (tagRepository.findByNameAndUserId(createTagDTO.getName(), createTagDTO.getUser()) != null) {
            throw new ApiException("Já existe uma tag com esse nome para este usuário", HttpStatus.BAD_REQUEST);
        }
        Tag tag = new Tag();
        tag.setName(createTagDTO.getName());
        tag.setUser(userService.getUserById(createTagDTO.getUser()));
        tag.setDefault(false);
        tag.setCreatedAt(LocalDateTime.now());
        tag.setUpdatedAt(LocalDateTime.now());

        return tagRepository.save(tag);
    }

    @Override
    public Tag getTagById(UUID id) {
        Tag tag = tagRepository.findById(id);
        if (tag == null) {
            throw new ApiException("Tag não encontrada", HttpStatus.NOT_FOUND);
        }

        return tag;
    }

    @Override
    public List<Tag> getTags() {
        return tagRepository.findAll();
    }

    @Override
    public List<Tag> getTagsForUser(UUID userId) {
        return tagRepository.findByUserIdOrIsDefault(userId, false);
    }

    @Override
    public void deleteTagById(UUID id) {
        Tag tag = tagRepository.findById(id);
        if (tag == null) {
            throw new ApiException("Tag não encontrada", HttpStatus.NOT_FOUND);
        }

        if (tag.isDefault()) {
            throw new ApiException("Tags padrão não podem ser excluídas", HttpStatus.BAD_REQUEST);
        }

        tagRepository.deleteById(id);
    }
}
