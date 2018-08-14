package com.hotelgo.repository;

import com.hotelgo.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query("select a from User a where a.username = ?1")
    Optional<User> findByUserName (String username);


    @Query("select a from User a where a.email = ?1")
    User findByEmail (String email);
}
