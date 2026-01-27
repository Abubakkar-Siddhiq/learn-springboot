package com.monkey.blog.controllers;

import com.monkey.blog.domain.dtos.CreateTagsRequest;
import com.monkey.blog.domain.dtos.TagResponse;
import com.monkey.blog.domain.entity.Tag;
import com.monkey.blog.mappers.TagMapper;
import com.monkey.blog.services.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/tags")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;
    private final TagMapper tagMapper;

    @GetMapping
    public ResponseEntity<List<TagResponse>> getAllTags() {
        List<Tag> tags = tagService.getTags();
        List<TagResponse> tagResponses = tags.stream().map(tagMapper::toTagResponse).toList();
        return ResponseEntity.ok(tagResponses);
    }

    @PostMapping
    public ResponseEntity<List<TagResponse>> createTags(
            @RequestBody CreateTagsRequest createTagsRequest
            ) {

    }
}
