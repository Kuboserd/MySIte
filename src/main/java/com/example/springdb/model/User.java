package com.example.springdb.model;

import com.example.springdb.model.place.World;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.List;

@Entity
@ToString
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true)
    @Setter
    private String login;

    @JsonIgnoreProperties("user")
    @OneToMany(mappedBy = "user")
    private List<Hero> heroList;

    @JsonIgnoreProperties("user")
    @OneToMany(mappedBy = "user")
    private List<World> worldList;

    @Column(nullable = false, unique = true)
    @Setter
    private String email;

    @Column(nullable = false)
    @Setter
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @ColumnDefault("'ROLE_USER'")
    @Setter
    private Roles role;

    public enum Roles {
        ROLE_USER, ROLE_ADMIN
    }

    public User() {
    }

    public User(Long id, String login, String email, String password, Roles role) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
