package com.hotelgo.repository;

import com.hotelgo.domain.Room;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoomRepository extends CrudRepository<Room, Long> {

    @Query("select a from Room a where a.hotel = ?1")
    Room findRoomsByHotel(String hotel_id);
}
