package com.example.blogApp.service;

import com.example.blogApp.entity.Blog;
import com.example.blogApp.entity.User;

import com.example.blogApp.repository.BlogRepository;
import com.example.blogApp.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Blogservice {
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private UserRepository userRepository;
    public Blog addBlog(Long userId, String title, String content){
        Optional<User> userOptional=userRepository.findById(userId);
        if(userOptional.isEmpty()){
            throw new RuntimeException("Author not found");
        }
        Blog blog=new Blog();
        blog.setTitle(title);
        blog.setContent(content);
        blog.setAuthor(userOptional.get());
        return blogRepository.save(blog);

    }
    public Page<Blog> getAllBlogs(int page,int size) {
        Pageable pageable= PageRequest.of(page,size);
        return blogRepository.findAll(pageable);
    }
     public Blog getBlogById(Long id){
        return blogRepository.findById(id).orElseThrow(()-> new RuntimeException("Blog not found with id:"+id));
     }
     public void deleteBlog(Long id){
        blogRepository.deleteById(id);
     }
     public Blog updateBlog(Long id,String title,String content){
        Blog blog=getBlogById(id);
        blog.setTitle(title);
        blog.setContent(content);
        return blogRepository.save(blog);
     }
    public Page<Blog> searchByAuthor(String authorName, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Blog> result=blogRepository.findByAuthorNameContainingIgnoreCase(authorName, pageable);
        if(result.isEmpty()){
            throw new RuntimeException("No blogs found for author name:"+authorName);
        }
        return result;
    }

    public Page<Blog> searchByTitle(String title, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Blog> result=blogRepository.findByTitleContainingIgnoreCase(title, pageable);
        if(result.isEmpty()){
            throw new RuntimeException("No blogs found for title:"+title);
        }
        return result;
    }

}
