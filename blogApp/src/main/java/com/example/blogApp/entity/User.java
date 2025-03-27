package com.example.blogApp.entity;

import jakarta.persistence.*;


import java.time.Instant;


@Entity
@Table(name="users",indexes = {
        @Index(name="idx_user_email",columnList="email")
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 100)
    private String name;
    @Column(nullable = false,unique = true,length = 255)
    private String email;
    @Column(nullable = false,length=255)
    private String password;

    @Column(name="created_at",updatable = false)
    private Instant createdAt;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)

   @PrePersist
           public void prePersist(){
        this.createdAt=Instant.now();
    }

    public User() {
    }

    public User(Long id, String name, String email, String password, Instant createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }



    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
