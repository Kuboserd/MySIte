package com.example.springdb.model.place;


import com.example.springdb.model.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
public class World extends Space {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Setter
    @Getter
    @ManyToOne
    @JsonIgnoreProperties("worldList")
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnoreProperties("world")
    @OneToMany(mappedBy = "world")
    private List<Place> placeList;

    public World(){}
}
