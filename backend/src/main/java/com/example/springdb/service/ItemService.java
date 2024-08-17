package com.example.springdb.service;

import com.example.springdb.model.User;
import com.example.springdb.model.shop.item.Item;
import com.example.springdb.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public List<Item> findAll(User user) {return itemRepository.findByUserID(user.getId());}

    public Item add(Item item) {
        return itemRepository.save(item);
    }
}
