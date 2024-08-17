package com.example.springdb.model.shop.item;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class ItemTag {
    @Id
    private String name;

    @ManyToMany(mappedBy = "itemTagList")
    private List<Item> itemList;
}
