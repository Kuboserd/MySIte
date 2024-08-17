package com.example.springdb.model.shop;


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
            joinColumns = { @JoinColumn(name = "tag_name") },
            inverseJoinColumns = { @JoinColumn(name = "shop_id") }
    )
    private List<ShopTag> shopTagList;

    @Getter
    @OneToOne
    @JoinColumn(name = "stock_id")
    private ShopStock shopStock;
}
