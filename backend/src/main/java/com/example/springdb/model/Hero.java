package com.example.springdb.model;

import com.example.springdb.model.shop.order.Order;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @Setter
    @ManyToOne
    @JsonIgnoreProperties("heroList")
    @JoinColumn(name = "user_id")
    private User user;

    private double gold;

    @JsonIgnoreProperties("hero")
    @OneToOne(mappedBy = "hero")
    private Order order;

    public Hero() {
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", gold=" + gold +
                '}';
    }
}
