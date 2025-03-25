package com.finapi.application.seed;

import com.finapi.application.port.out.TagRepository;
import com.finapi.domain.model.Tag;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class TagSeedService {

    private final TagRepository tagRepository;

    public TagSeedService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @PostConstruct
    public void seedDefaultTags() {
        List<String> defaultTagNames = Arrays.asList(
                "Alimentação",
                "Transporte",
                "Educação",
                "Saúde",
                "Lazer",
                "Moradia"
        );

        for (String tagName : defaultTagNames) {
            if (!tagRepository.existsByNameAndIsDefault(tagName, true)) {
                Tag tag = new Tag();
                tag.setName(tagName);
                tag.setDefault(true);
                tag.setUser(null);
                tag.setCreatedAt(LocalDateTime.now());
                tag.setUpdatedAt(LocalDateTime.now());
                tagRepository.save(tag);
            }
        }
    }
}