package com.monkey.blog.services;

import com.monkey.blog.domain.CreatePostRequest;
import com.monkey.blog.domain.UpdatePostRequest;
import com.monkey.blog.domain.entity.Post;
import com.monkey.blog.domain.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public interface PostService {
    Post getPost(UUID id);
    List<Post> getAllPosts(UUID categoryId, UUID tagId);
    List<Post> getDraftPosts(User user);
    Post createPost(User user, CreatePostRequest createPostRequest);
    void deletePost(UUID id);

    @Transactional
    Post updatePost(UUID id, UpdatePostRequest updatePostRequest);
}
