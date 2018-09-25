package com.hotelgo.service;

import com.hotelgo.domain.Hotel;
import com.hotelgo.domain.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class ImageService {

    @Autowired
    public StorageService storageService;
    @Autowired
    public HotelService hotelService;

    public Image uploadHotelImage(Long hotelId,MultipartFile imageFile){

        UUID uuid = UUID.randomUUID();
        String UUIDString = uuid.toString();
        File file = null;

        try {
            file = storageService.multipartToFile(imageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        storageService.upload(UUIDString, file);
        String objectUrl = storageService.getObjectUrl(UUIDString);
        Image image = new Image();
        Hotel ht = hotelService.findById(hotelId);
        image.setHotel(ht);
        image.setUrl(objectUrl);

        return image;
    }






}
