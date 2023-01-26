package com.example.springdb.model.place;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.MappedSuperclass;

@ToString
@Getter
@MappedSuperclass
public abstract class Place {

    private String name;

    private String description;

    public Place(){}

}
