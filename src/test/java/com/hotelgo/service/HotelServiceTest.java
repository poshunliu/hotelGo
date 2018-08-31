package com.hotelgo.service;

import com.hotelgo.config.AppConfig;
import com.hotelgo.domain.Hotel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;


@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
public class HotelServiceTest {

    @Autowired
    private HotelService hotelService;

    @Test
    @Transactional
    public void getHotelByNameTest(){
        Hotel hotel = new Hotel();
        hotel.setHotelName("Hyatt Regency Tysons Corner Center");
        hotel.setCity("Tysons Corner");
        hotel.setContact_phone("123-456-7890");
        hotel.setEmail("Hyatt_tysons@gmail.com");
        hotel.setStar_level("five");
        hotelService.save(hotel);

        Hotel expectedHotel = hotelService.findByName(hotel.getHotelName());
        assertEquals(hotel.getHotelName(), expectedHotel.getHotelName());


    }
}
