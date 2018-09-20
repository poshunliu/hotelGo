package com.hotelgo.service;

import com.hotelgo.domain.Room;
import com.hotelgo.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class RoomSerivce {

    @Autowired
    private RoomRepository roomRepository;
    @Transactional
    public Room save(Room room){
        return roomRepository.save(room);
    }
    @Transactional
    public Room findRoomsByHotel(String hotel_id){
        return roomRepository.findRoomsByHotel(hotel_id);
    }
}
