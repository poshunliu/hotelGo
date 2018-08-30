package com.hotelgo.api.v1;

import com.hotelgo.domain.Hotel;
import com.hotelgo.repository.HotelRepository;
import com.hotelgo.service.HotelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = {"/api/hotels","/api/hotel"},produces = MediaType.APPLICATION_JSON_VALUE)
public class HotelController {


    public final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public HotelService hotelService;



    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Hotel getHotelByName(String hotelName){
        logger.debug("get Hotel List");
        Hotel result = hotelService.findByName(hotelName);
        return result;
    }


    @RequestMapping(value= "/{Id}",method = RequestMethod.GET)
    @ResponseBody
    public Hotel getHotelById(@PathVariable("Id") long id){
        logger.debug("get the hotel by id");
        Hotel result = hotelService.findById(id);
        return result;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Hotel save(@RequestBody Hotel hotel){

        logger.debug("sign up new hotel");
        Hotel result = hotelService.save(hotel);
        return result;

    }



}
