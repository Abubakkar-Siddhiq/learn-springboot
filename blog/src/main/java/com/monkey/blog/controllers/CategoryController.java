package com.monkey.blog.controllers;

import com.monkey.blog.domain.dtos.CategoryDto;
import com.monkey.blog.domain.dtos.CreateCategoryRequest;
import com.monkey.blog.domain.entity.Category;
import com.monkey.blog.mappers.CategoryMapper;
import com.monkey.blog.services.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> listCategories() {
        List<CategoryDto> categories = categoryService.listCategories()
                .stream().map(categoryMapper::toDto).toList();
        return ResponseEntity.ok(categories);
    }

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(
            @RequestBody @Valid CreateCategoryRequest createCategoryRequest
    ) {
        Category categoryToCrate = categoryMapper.toEntity(createCategoryRequest);
        Category savedCategory =  categoryService.createCategory(categoryToCrate);

        return new ResponseEntity<>(
                categoryMapper.toDto(savedCategory),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping(path = "/{id}")
    public  ResponseEntity<Void> deleteCategory(@PathVariable UUID id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}