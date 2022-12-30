package com.example.springdb.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    @Setter
    private String login;

    @Column(nullable = false, unique = true)
    @Setter
    private String email;

    @Setter
    private String password;

    @Enumerated(EnumType.STRING)
    @Setter
    private Roles role;

    public enum Roles{
        ROLE_USER, ROLE_ADMIN
    }


    public User(Long id, String login, String email, String password, Roles role) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
