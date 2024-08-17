package com.example.springdb.repository;

import com.example.springdb.model.shop.item.ItemTag;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemTagRepository extends CrudRepository<ItemTag, Long> {

    @Query(value = "SELECT * FROM World WHERE user_id=:id", nativeQuery = true)
    List<ItemTag> findByUserID(@Param("id")long id);

}
