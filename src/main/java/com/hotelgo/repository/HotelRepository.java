package com.hotelgo.repository;

import com.hotelgo.domain.Hotel;
import com.hotelgo.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface HotelRepository extends CrudRepository<Hotel, Long> {
}
