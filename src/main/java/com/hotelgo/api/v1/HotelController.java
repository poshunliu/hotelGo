package com.hotelgo.api.v1;

import com.hotelgo.domain.Hotel;
import com.hotelgo.service.HotelService;
import com.hotelgo.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.File;

@RestController
@RequestMapping(value = {"/api/hotels","/api/hotel"},produces = MediaType.APPLICATION_JSON_VALUE)
public class HotelController {


    public final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public HotelService hotelService;
    @Autowired
    public StorageService storageService;

    @RequestMapping(value = "name", method = RequestMethod.GET)
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

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Hotel save(@RequestBody Hotel hotel){
        logger.debug("sign up new hotel");
        Hotel result1 = hotelService.save(hotel);
        return result1;

    }

    @RequestMapping(value = "/{Id}/image", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String upLoadHotelImage(@PathVariable("Id") Long Id, File image){

        storageService.upload("Brandon.image", image);
        String result = storageService.getObjectUrl("Brandon.image");
        return result;
    }

}
