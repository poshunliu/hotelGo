package com.hotelgo.service;

import com.amazonaws.services.s3.AmazonS3;
import com.hotelgo.config.AppConfig;
import com.hotelgo.domain.Hotel;
import com.hotelgo.domain.Image;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Iterator;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
public class ImageServiceTest {

    @Autowired
    public ImageService imageService;
    @InjectMocks
    @Autowired
    public StorageService storageService;
    @Autowired
    public HotelService hotelService;
    @Mock
    private AmazonS3 client = mock(AmazonS3.class);




//    @Test
//    @Transactional
//    public void uploadHotelImageTest(){
//
//        Hotel hotel = new Hotel();
//        hotel.setHotelName("Hyatt Regency Tysons Corner Center");
//        hotel.setCity("Tysons Corner");
//        hotel.setContact_phone("123-456-7890");
//        hotel.setEmail("Hyatt_tysons@gmail.com");
//        hotel.setStarLevel("five");
//        hotelService.save(hotel);
//        long hotelId = 55;
//
//
//        MultipartFile multipartFile=Mockito.mock(MultipartFile.class);
//        when(multipartFile.getOriginalFilename()).thenReturn("test");
//        String multipartFile1 = multipartFile.getOriginalFilename();
//
//
//
//        Image imageUpLoad = imageService.uploadHotelImage(hotelId, multipartFile);
//        verify(client, times(1)).putObject("hotelGo-dev", anyString(), any(File.class));
//        assertNotNull(imageUpLoad.getUrl());
//        assertNotNull(imageUpLoad.getHotel());
//    }


    @Test
    public void testMoreThanOneReturnValue()  {
        Iterator<String> i= mock(Iterator.class);
        when(i.next()).thenReturn("Mockito").thenReturn("rocks");
        String result= i.next()+" "+i.next();
        //assert
        assertEquals("Mockito rocks", result);
    }

}
