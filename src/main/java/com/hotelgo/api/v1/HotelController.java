package com.hotelgo.api.v1;

import com.hotelgo.domain.Hotel;
import com.hotelgo.domain.Image;
import com.hotelgo.service.HotelService;
import com.hotelgo.service.ImageService;
import com.hotelgo.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = {"/api/hotels","/api/hotel"})
public class HotelController {

    public final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    public HotelService hotelService;
    @Autowired
    public StorageService storageService;
    @Autowired
    public ImageService imageService;

    @RequestMapping(value = "/name",params = "hotelName", method = RequestMethod.GET)
    @ResponseBody
    public Hotel getHotelByName(@RequestParam("hotelName")String hotelName){
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

    @RequestMapping(value = "/{Id}/image", method = RequestMethod.POST, consumes = {"multipart/form-data"})
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Image upLoadHotelImage(@PathVariable("Id") Long hotelId, @RequestParam(value="file") MultipartFile multipartFile) {

        Image upload = imageService.uploadHotelImage(hotelId, multipartFile);
        return upload;
    }
}
