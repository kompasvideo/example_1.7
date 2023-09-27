package com.example.users.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Getter
@Setter
@Entity
@ToString
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "username")
    private String name;

    @NonNull
    @Column(name = "email")
    private String email;

    public User() {
        this.id = 0l;
        this.name = "";
        this.email = "";
    }

    public User(Long id, @NonNull String name, @NonNull String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
