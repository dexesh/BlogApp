package com.example.blogApp.controller;

import com.example.blogApp.entity.Blog;
import com.example.blogApp.service.Blogservice;
import com.example.blogApp.service.Geminiservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping("api/blogs")
public class BlogController {
    @Autowired
    private Blogservice blogservice;
    @Autowired
    private Geminiservice geminiservice;
    @PostMapping("/{userId}")
    public Blog addBlog(@PathVariable Long userId, @RequestBody Map<String, String> request) {
        String title = request.get("title");
        String content = request.get("content");
        return blogservice.addBlog(userId, title, content);
    }
    @GetMapping
    public Page<Blog> getAllBlogs(@RequestParam int page,@RequestParam int size){
        return blogservice.getAllBlogs(page,size);

    }
    @GetMapping("/{id}")
    public Blog getBlogById(@PathVariable Long id){
        return blogservice.getBlogById(id);
    }
    @PutMapping("/{id}")
    public Blog updateBlog(@PathVariable Long id, @RequestBody Map<String, String> request) {
        String title = request.get("title");
        String content = request.get("content");
        return blogservice.updateBlog(id, title, content);
    }

    @DeleteMapping("/{id}")
    public void deleteBlog(@PathVariable Long id){
      blogservice.deleteBlog(id);
    }
    @GetMapping("/search/author")
    public Page<Blog> searchByAuthor(@RequestParam String authorName,@RequestParam int page,@RequestParam int size){
        return blogservice.searchByAuthor(authorName,page,size);
    }
    @GetMapping("/search/title")
    public Page<Blog> searchByTitle(@RequestParam String title,@RequestParam int page,@RequestParam int size){
        return blogservice.searchByTitle(title, page, size);
    }
    @GetMapping("/{id}/summary")
    public Mono<String> getBlogSummary(@PathVariable Long id) {
        String content = blogservice.getBlogById(id).getContent();
        return geminiservice.generateSummary(content);
    }



}
