package com.hotelgo.repository;

import com.hotelgo.domain.Room;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoomRepository extends CrudRepository<Room, Long> {

    @Query("select a from Room a where a.hotel.id = ?1")
    List<Room> findByHotelId(Long id);
}
