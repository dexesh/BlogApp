package com.example.blogApp.repository;

import com.example.blogApp.entity.Blog;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog,Long> {

    Page<Blog> findByTitleContainingIgnoreCase(String title, Pageable pageable);
    Page<Blog> findByAuthorNameContainingIgnoreCase(String name,Pageable pageable);
}
