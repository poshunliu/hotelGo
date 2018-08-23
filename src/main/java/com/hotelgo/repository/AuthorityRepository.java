package com.hotelgo.repository;

import com.hotelgo.domain.Authority;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface AuthorityRepository extends CrudRepository<Authority,Long> {


    @Query("select a from Authority a where a.user.id = ?1")
    List<Authority> findByUserId (Long userId);

}
