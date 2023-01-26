package com.example.springdb.model.dto;

import com.example.springdb.model.place.Place;

public class WorldDTO {

    private String name;

    private String description;

    WorldDTO(Place place) {
        this.name = place.getName();
        this.name = place.getDescription();
    }
}
