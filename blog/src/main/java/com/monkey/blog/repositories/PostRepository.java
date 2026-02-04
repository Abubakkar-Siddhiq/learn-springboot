package com.monkey.blog.repositories;

import com.monkey.blog.domain.PostStatus;
import com.monkey.blog.domain.entity.Category;
import com.monkey.blog.domain.entity.Post;
import com.monkey.blog.domain.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {
    List<Post> findAllByStatusAndCategoryAndTagsContaining(PostStatus status, Category category, Tag tag);
    List<Post> findAllByStatusAndCategory(PostStatus status, Category category);
    List<Post> findAllByStatusAndTag(PostStatus status, Tag tag);
    List<Post> findAllByStatus(PostStatus status);
}
