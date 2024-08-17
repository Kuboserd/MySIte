package com.example.springdb.model.dto;

import com.example.springdb.model.place.Space;

public class WorldDTO {

    private String name;

    private String description;

    WorldDTO(Space space) {
        this.name = space.getName();
        this.name = space.getDescription();
    }
}
