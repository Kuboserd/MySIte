package com.example.springdb.model.place;


import com.example.springdb.model.User;
import lombok.Getter;

import javax.persistence.*;

@Entity
public class World extends Place {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Getter
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public World(){}
}
