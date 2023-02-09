package com.example.springdb.repository;

import com.example.springdb.model.Hero;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface HeroRepository extends CrudRepository<Hero, Long> {

    @Query(value = "SELECT * FROM hero WHERE user_id=:id", nativeQuery = true)
    List<Hero> findByUserID(@Param("id") long id);

}
