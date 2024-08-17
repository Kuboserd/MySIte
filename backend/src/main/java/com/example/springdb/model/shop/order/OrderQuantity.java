package com.example.springdb.model.shop.order;

import com.example.springdb.model.shop.item.Item;

import javax.persistence.*;
import java.util.List;

@Entity
public class OrderQuantity {
    @Id
    private long id;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToMany(mappedBy = "orderQuantityList")
    private List<Order> order;
}
