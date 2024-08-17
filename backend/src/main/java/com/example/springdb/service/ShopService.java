package com.example.springdb.service;

import com.example.springdb.model.User;
import com.example.springdb.model.shop.Shop;
import com.example.springdb.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ShopService {
    private final ShopRepository shopRepository;

    public List<Shop> findAll(User user) {return shopRepository.findByUserID(user.getId());}

    public List<Shop>findall(){return StreamSupport.stream(shopRepository.findAll().spliterator(),false).toList(); }

    public Shop add(Shop shop) {
        return shopRepository.save(shop);
    }
}
