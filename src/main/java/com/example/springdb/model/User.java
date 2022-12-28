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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Setter
    private String firstName;

    @Column(nullable = false)
    @Setter
    private String lastName;

    @Column(nullable = false, unique = true)
    @Setter
    private String login;

    @Setter
    private String password;

    @Enumerated(EnumType.STRING)
    private Roles role;

    public enum Roles{
        ROLE_USER, ROLE_ADMIN
    }

    public User(String firstName, String lastName, String login, String password, Roles role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public static void main(String[] args) {

    }


}
