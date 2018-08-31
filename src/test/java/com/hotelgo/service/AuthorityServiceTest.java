package com.hotelgo.service;

import com.hotelgo.config.AppConfig;
import com.hotelgo.domain.Authority;
import com.hotelgo.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.Assert.assertNotNull;


@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
public class AuthorityServiceTest {

    @Autowired
    private AuthorityService authorityService;
    @Autowired
    private UserService userService;


    @Test
    @Transactional
    public void addAuthorityTest(){
        User user = new User();
        Authority authority = new Authority();
        user.setUsername("Tommy");
        user.setEmail("brandonpass@gmail.com");
        user.setFirstName("Pual");
        user.setPassword("abcd");
        user.setLastName("LIU");
        user.setAccountExpire(true);

        userService.save(user);
        authorityService.addAuthority(user,authority);
        Long result = authority.getId();

        assertNotNull(result);




    }
}
