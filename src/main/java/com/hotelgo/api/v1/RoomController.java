package com.hotelgo.api.v1;

import com.hotelgo.domain.Hotel;
import com.hotelgo.domain.Room;
import com.hotelgo.repository.RoomRepository;
import com.hotelgo.service.HotelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = {"/api","/api"},produces = MediaType.APPLICATION_JSON_VALUE)
public class RoomController {

    public final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public RoomRepository roomRepository;
    @Autowired
    public HotelService hotelService;

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


    @RequestMapping(value = "hotel", method = RequestMethod.GET)
    @ResponseBody
    public Room getRoombyHotel(String hotelName){

        logger.debug("find room by hotel");
         Room result = roomRepository.findRoomsByHotel(hotelName);
         return result;


    }
}
