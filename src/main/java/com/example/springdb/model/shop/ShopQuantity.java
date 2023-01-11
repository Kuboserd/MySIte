package com.example.springdb.model.shop;

import com.example.springdb.model.shop.item.Item;

import javax.persistence.*;
import java.util.List;

@Entity
public class ShopQuantity {
    @Id
    private long id;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToMany(mappedBy = "shopQuantityList")
    private List<ShopStock> shopStockList;
}

