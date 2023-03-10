package com.example.springdb.model.shop;


import javax.persistence.*;
import java.util.List;

@Entity
public class ShopStock {
    @Id
    private long id;

    @OneToOne(mappedBy = "shopStock")
    @JoinColumn(name = "shop_id")
    private Shop shop;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "shop_stock_details",
            joinColumns = {@JoinColumn(name = "item_id")},
            inverseJoinColumns = {@JoinColumn(name = "stock_id")}
    )
    private List<ItemDetails> item_details_list;
}
