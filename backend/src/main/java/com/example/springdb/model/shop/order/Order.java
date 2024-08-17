package com.example.springdb.model.shop.order;

import com.example.springdb.model.Hero;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity(name = "orders")
public class Order {
    @Id
    private long id;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "order_details",
            joinColumns = {@JoinColumn(name = "item_id")},
            inverseJoinColumns = {@JoinColumn(name = "order_id")}
    )
    private List<OrderQuantity> orderQuantityList;

    @JsonIgnoreProperties("order")
    @OneToOne
    @JoinColumn(name = "hero_id")
    private Hero hero;
}
