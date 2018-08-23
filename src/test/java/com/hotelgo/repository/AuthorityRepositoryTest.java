package com.hotelgo.repository;

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

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
public class AuthorityRepositoryTest {


    @Autowired
    private AuthorityRepository authorityRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    public void findByUserIdTest(){

        User user = new User();
        user.setFirstName("Brandon");
        user.setEmail("brandon@gmail.com");
        user.setLastName("Liu");
        user.setAccountExpire(true);
        user.setUsername("brandon");
        user.setPassword("123345");
        userRepository.save(user);

        Authority authority = new Authority();
        authority.setAuthority("REGISTERED_USER");
        authority.setUser(user);
        authorityRepository.save(authority);

        Authority authority2 = new Authority();
        authority2.setAuthority("ADMIN");
        authority2.setUser(user);
        authorityRepository.save(authority2);

        List<Authority> authorities = authorityRepository.findByUserId(user.getId());
        assertEquals(authorities.size(),2);


//        Optional<User> testUser = u.findById(user.getId());
//        assertNotNull(testUser);
//        assertEquals(user.getId(), testUser.get().getId());
//        assertTrue(false);

    }
}
