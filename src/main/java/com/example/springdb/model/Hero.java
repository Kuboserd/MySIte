package com.example.springdb.model;

import com.example.springdb.model.shop.order.Order;

import javax.persistence.*;


@Entity
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    float goldCoins;

    @OneToOne(mappedBy = "hero")
    private Order order;

    public Hero() {
    }
}
