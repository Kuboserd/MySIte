package com.example.springdb.model.shop.item;

import com.example.springdb.model.shop.ShopQuantity;
import com.example.springdb.model.shop.order.OrderQuantity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private ITEM_TYPE type;

    private double cost;

    private double weight;

    private String description;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "item_tags",
            joinColumns = { @JoinColumn(name = "tag_name") },
            inverseJoinColumns = { @JoinColumn(name = "item_id") }
    )
    private List<ItemTag> itemTagList;

    @OneToMany(mappedBy = "item")
    private List<OrderQuantity> orderQuantityList;

    @OneToMany(mappedBy = "item")
    private List<ShopQuantity> shopQuantityList;

    private String attributes;

    public Item() {
    }
}
