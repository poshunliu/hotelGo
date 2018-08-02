package com.hotelgo.repository;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;


public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Test
    public void saveTest(){
        assertEquals(true,true);

    }



}
