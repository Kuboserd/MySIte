package com.example.springdb.repository;

import com.example.springdb.model.shop.item.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Long> {

    @Query(value = "SELECT * FROM World WHERE user_id=:id", nativeQuery = true)
    List<Item> findByUserID(@Param("id")long id);

}
