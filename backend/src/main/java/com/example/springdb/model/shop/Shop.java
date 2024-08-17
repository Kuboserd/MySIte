package com.example.springdb.model.shop;


import com.example.springdb.model.shop.item.Item;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
public class Shop {
    @Id
    private long id;

    @Getter
    private String name;

    @Getter
    private String description;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "shop_tags",
            joinColumns = {@JoinColumn(name = "tag_name")},
            inverseJoinColumns = {@JoinColumn(name = "shop_id")}
    )
    private List<ShopTag> shopTagList;


    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "shop_stock",
            joinColumns = {@JoinColumn(name = "item_id")},
            inverseJoinColumns = {@JoinColumn(name = "shop_id")}
    )
    private List<Item> itemList;
}
