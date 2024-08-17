package com.example.springdb.model.shop;

import com.example.springdb.model.shop.item.Item;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
public class ItemDetails {
    @Id
    private long id;

    @Getter
    private int quantity;
    @Getter
    private double price;

    @Getter
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToMany(mappedBy = "itemList")
    private List<Shop> shopList;
}

