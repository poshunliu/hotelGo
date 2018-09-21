package com.hotelgo.api.v1;

import com.hotelgo.domain.Hotel;
import com.hotelgo.domain.Room;
import com.hotelgo.repository.RoomRepository;
import com.hotelgo.service.HotelService;
import com.hotelgo.service.RoomSerivce;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/api","/api"},produces = MediaType.APPLICATION_JSON_VALUE)
public class RoomController {

    public final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public RoomRepository roomRepository;
    @Autowired
    public HotelService hotelService;
    @Autowired
    public RoomSerivce roomSerivce;

    @RequestMapping(value = "/hotel/{hotel_id}/room", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Room save(@RequestBody Room room ,@PathVariable("hotel_id") Long hotelId){
        Hotel hotel = hotelService.findById(hotelId);
        logger.debug("sign up new hotel");
        room.setHotel(hotel);
        Room result = roomRepository.save(room);
        return result;
    }

    @RequestMapping(value = "/hotel/{hotel_id}/room", method = RequestMethod.GET)
    @ResponseBody
    public List<Room> getRoombyHotel(@PathVariable("hotel_id") Long id){

        logger.debug("find room by hotel");
        List<Room> result = roomSerivce.findRoomsByHotel(id);
        return result;
    }
}
