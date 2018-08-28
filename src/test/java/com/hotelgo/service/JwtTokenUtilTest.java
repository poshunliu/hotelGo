package com.hotelgo.service;

import com.auth0.jwt.interfaces.Claim;
import com.hotelgo.config.AppConfig;
import com.hotelgo.domain.User;
import com.hotelgo.extend.security.JwtTokenUtil;
import com.hotelgo.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.LiteDevice;
import org.springframework.security.core.userdetails.UserDetails;
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
public class JwtTokenUtilTest {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Test
    @Transactional
    public void getUsernameFromTokenTest(){


        User user = new User();
        user.setUsername("GmuCS");
        user.setEmail("gmu.cs@gmail.com");
        user.setFirstName("Liu");
        user.setLastName("Po");
        user.setPassword("jawdx1989");
        user.setAccountExpire(true);
        userRepository.save(user);

        Device device = new LiteDevice();
        String token = jwtTokenUtil.generateToken(user, device);
        String expect = jwtTokenUtil.getUsernameFromToken(token);

        assertEquals(user.getUsername(),expect);











    }

}
