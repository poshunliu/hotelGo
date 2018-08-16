package com.hotelgo.repository;

import com.hotelgo.domain.Hotel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface HotelRepository extends CrudRepository<Hotel, Long> {

    @Query("select a from Hotel a where a.hotelName = ?1")
    Optional<Hotel> findByHotelName (String hotelName);
}
