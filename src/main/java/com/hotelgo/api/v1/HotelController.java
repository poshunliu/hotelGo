package com.hotelgo.api.v1;

import com.hotelgo.domain.Hotel;
import com.hotelgo.service.HotelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/api/hotels","/api/hotel"},produces = MediaType.APPLICATION_JSON_VALUE)
public class HotelController {


    public final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public HotelService hotelService;



    public Hotel getHotelByName(String hotelName){
        logger.debug("get Hotel List");
        Hotel result = hotelService.findByName(hotelName);
        return result;
    }


    public Hotel getHotelById(long id){
        logger.debug("get the hotel by id");
        Hotel result = hotelService.findById(id);
        return result;
    }



}
