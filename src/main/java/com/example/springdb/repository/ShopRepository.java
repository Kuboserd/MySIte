package com.example.springdb.repository;

import com.example.springdb.model.shop.Shop;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShopRepository extends CrudRepository<Shop, Long> {

    @Query(value = "SELECT * FROM World WHERE user_id=:id", nativeQuery = true)
    List<Shop> findByUserID(@Param("id")long id);

}
