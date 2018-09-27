package com.hotelgo.service;

import com.hotelgo.config.AppConfig;
import com.hotelgo.domain.User;
import com.hotelgo.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.Optional;

import static org.junit.Assert.assertEquals;


@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;
    @PersistenceContext()
    private EntityManager em;

    @Test
    @Transactional
    public void findByEmailTest(){
        User user = new User();
        user.setUsername("JJJJ");
        user.setEmail("brandontw617@gmail.com");
        user.setFirstName("Liu");
        user.setPassword("1234");
        user.setLastName("lastname");
        user.setAccountExpire(true);
        userService.save(user);
        User expectedUser = userService.findByEmail(user.getEmail());
        assertEquals(user.getEmail(),expectedUser.getEmail());
    }


    public void findByUserName() throws Exception {
        User user = new User();
        user.setUsername("AAA");
        user.setEmail("nepia17@gmail.com");
        user.setFirstName("Wu");
        userRepository.save(user);
        User expectedUser = userService.findByName(user.getUsername());
    }


    public void saveUser(){
        User user = new User();
        user.setUsername("POSHUN");
        user.setEmail("brandontw617@gmail.com");
        user.setFirstName("POSHUN");
        user.setPassword("abcd");
        user.setLastName("LIU");
        user.setAccountExpire(true);
        userService.save(user);
        Optional <User> expectedUser = userRepository.findByEmail(user.getEmail());
        assertEquals(user.getEmail(), expectedUser.get());
    }





}
