package com.example.springdb.repository;

import com.example.springdb.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    @Query("from User u where u.password=:password")
    List<User> findByPassword(@Param("password") String password);

    @Query(value = "SELECT * FROM User WHERE login=:login", nativeQuery = true)
    Optional<User>findByLoginNative(@Param("login") String login);

}
