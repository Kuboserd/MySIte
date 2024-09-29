package com.example.springdb.repository;

import com.example.springdb.model.shop.Shop;
import org.springframework.data.repository.CrudRepository;

public interface ShopRepository extends CrudRepository<Shop, Long> {
}
