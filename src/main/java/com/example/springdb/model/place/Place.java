package com.example.springdb.model.place;

import lombok.ToString;

import javax.persistence.MappedSuperclass;

@ToString
@MappedSuperclass
public class Place {

    private String name;

    private String description;

    public Place(){}

}
