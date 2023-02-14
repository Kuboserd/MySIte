package com.example.springdb.service;

import com.example.springdb.model.User;
import com.example.springdb.model.shop.item.ItemTag;
import com.example.springdb.repository.ItemTagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemTagService {
    private final ItemTagRepository itemTagRepository;

    public List<ItemTag> findAll(User user) {return itemTagRepository.findByUserID(user.getId());}

    public ItemTag add(ItemTag itemTag) {
        return itemTagRepository.save(itemTag);
    }
}
