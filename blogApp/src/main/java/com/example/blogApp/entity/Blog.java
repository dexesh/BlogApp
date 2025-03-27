package com.example.blogApp.entity;

import jakarta.persistence.*;


import java.time.Instant;

@Entity
@Table(name="blogs",indexes = {
        @Index(name="idx_blog_title",columnList = "title"),
        @Index(name="idx_blog_author",columnList ="author_id")
})

public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 255)
    private String title;
    @Column(columnDefinition = "LONGTEXT",nullable = false)
     private String content;
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false, foreignKey = @ForeignKey(name = "fk_author"))
    private User author;


    @Column(name = "created_at", updatable = false)
    private Instant createdAt;
    @Column(name = "updated_at")
    private Instant updatedAt;
    @PrePersist
    public void prePersist(){
        this.createdAt=Instant.now();
        this.updatedAt=Instant.now();
    }
    @PreUpdate
    public void preUpdate(){
        this.updatedAt=Instant.now();
    }
    public Blog() {
    }

    public Blog(Long id, String title, String content, User author, Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}


