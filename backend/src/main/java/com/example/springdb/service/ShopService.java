package com.example.springdb.service;

import com.example.springdb.model.shop.Shop;
import com.example.springdb.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
@Slf4j
public class ShopService {
    private final ShopRepository shopRepository;

    public List<Shop> findAll() {
        return StreamSupport.stream(shopRepository.findAll().spliterator(), false).toList();
    }

    public Shop add(Shop shop) {
        return shopRepository.save(shop);
    }
}
