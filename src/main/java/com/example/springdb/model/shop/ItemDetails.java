package com.example.springdb.model.shop;

import com.example.springdb.model.shop.item.Item;

import javax.persistence.*;
import java.util.List;

@Entity
public class ItemDetails {
    @Id
    private long id;

    private int quantity;

    private double price;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToMany(mappedBy = "item_details_list")
    private List<ShopStock> shop_stock_details;
}

