package com.example.springdb.repository;

import com.example.springdb.model.place.World;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface WorldRepository extends CrudRepository<World, Long> {

    @Query(value = "SELECT * FROM World WHERE user_id=:id", nativeQuery = true)
    Optional<World>findByUserID(@Param("id") long id);

}
