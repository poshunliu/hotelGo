package com.hotelgo.service;

import com.google.common.collect.Lists;
import com.hotelgo.domain.Hotel;
import com.hotelgo.repository.HotelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {
    @Autowired
    public HotelRepository hotelRepository;
    @Transactional
    public List<Hotel> findAll(){
        List<Hotel> list = Lists.newArrayList(hotelRepository.findAll());
        return list;
    }


    @Transactional
    public Hotel findByName(String hotelName){
        Optional<Hotel> option = hotelRepository.findByHotelName(hotelName);
        Hotel hotel = option.get();
        return hotel;

    }







}
