//package com.hotelgo.repository;
//
//
//import com.hotelgo.config.AppConfig;
//import com.hotelgo.domain.User;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Optional;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//
//@WebAppConfiguration
//@ContextConfiguration(classes = {AppConfig.class})
//@RunWith(SpringJUnit4ClassRunner.class)
//@ActiveProfiles("unit")
//
//public class UserRepositoryTest {
//    @Autowired
//    private UserRepository userRepository;
//    @Test
//    @Transactional
//    public void saveTest(){
//        User user = new User();
//        user.setUsername("Brandon");
//        user.setEmail("brandontw617@gmail.com");
//
//
//        userRepository.save(user);
//        Optional<User> testUser = userRepository.findById(user.getId());
//        assertNotNull(testUser);
//        assertEquals(user.getId(), testUser.get().getId());
//
//
//    }
//
//
//
//
//
//
//
//
//}
