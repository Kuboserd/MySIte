package com.example.springdb.model.place;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Place extends Space{

    @Id
    private Long id;

    private PLACE_TYPE type;

    @JsonIgnoreProperties("placeList")
    @JoinColumn(name = "world_id")
    @ManyToOne
    private World world;

    @ManyToOne
    @JoinColumn(name = "parent_place")
    private Place place;
}
