package com.example.springdb.model.shop;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class ShopTag {
    @Id
    private String name;

    @ManyToMany(mappedBy = "shopTagList")
    private List<Shop> shopList;
}
