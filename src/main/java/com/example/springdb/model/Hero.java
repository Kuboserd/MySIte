package com.example.springdb.model;

import com.example.springdb.model.shop.order.Order;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import javax.persistence.*;


@Entity
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @Getter
    @ManyToOne
    @JsonIgnoreProperties("heroList")
    @JoinColumn(name = "user_id")
    private User user;

    private float goldCoins;

    @JsonIgnoreProperties("hero")
    @OneToOne(mappedBy = "hero")
    private Order order;

    public Hero() {
    }
}
