package com.monkey.blog.services.impl;

import com.monkey.blog.domain.entity.Tag;
import com.monkey.blog.repositories.TagRepository;
import com.monkey.blog.services.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    @Override
    public List<Tag> getTags() {
        return tagRepository.findAllWithPostCount();
    }

    @Override
    public List<Tag> createTags(Set<String> tagNames) {
        return List.of();
    }
}
