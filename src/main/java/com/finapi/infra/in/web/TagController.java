package com.finapi.infra.in.web;

import com.finapi.application.dto.request.CreateTagDTO;
import com.finapi.application.dto.response.ResponseTagDTO;
import com.finapi.application.service.TagService;
import com.finapi.config.RequiresAuthentication;
import com.finapi.domain.model.Tag;
import com.finapi.infra.out.mapper.TagMapper;
import com.finapi.infra.security.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tags")
public class TagController {

    private final TagService tagService;
    private final JwtUtil jwtUtil;

    public TagController(TagService tagService, JwtUtil jwtUtil) {
        this.tagService = tagService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping
    @RequiresAuthentication
    public ResponseTagDTO createTag(@RequestBody CreateTagDTO createTagDTO, HttpServletRequest request) {
        String token = request.getHeader("Authorization").substring(7);
        UUID userId = jwtUtil.getUserIdFromToken(token);

        createTagDTO.setUser(userId);

        Tag tag = tagService.createTag(createTagDTO);
        return TagMapper.toDTO(tag);
    }

    @GetMapping
    @RequiresAuthentication
    public List<ResponseTagDTO> getTags() {
        return TagMapper.toDTOList(tagService.getTags());
    }

    @GetMapping("/{tagId}")
    @RequiresAuthentication
    public ResponseTagDTO getTag(@PathVariable UUID tagId) {
        return TagMapper.toDTO(tagService.getTagById(tagId));
    }

    @GetMapping("/user")
    @RequiresAuthentication
    public List<ResponseTagDTO> getUserTags(HttpServletRequest request) {
        String token = request.getHeader("Authorization").substring(7);
        UUID userId = jwtUtil.getUserIdFromToken(token);

        return TagMapper.toDTOList(tagService.getTagsForUser(userId));
    }

    @DeleteMapping("/{tagId}")
    @RequiresAuthentication
    public void deleteTag(@PathVariable UUID tagId) {
        tagService.deleteTagById(tagId);
    }
}