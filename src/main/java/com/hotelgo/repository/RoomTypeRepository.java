package com.hotelgo.repository;

import com.hotelgo.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface RoomTypeRepository extends CrudRepository<User, Long> {
}
