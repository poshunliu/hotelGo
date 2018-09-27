package com.hotelgo.extend.security;

import com.hotelgo.domain.Authority;
import com.hotelgo.domain.User;
import com.hotelgo.service.AuthorityService;
import com.hotelgo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;
    @Autowired
    private AuthorityService authorityService;


    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = null;
        try {
            user = userService.findByName(username);
        } catch (Exception e) {
            Logger logger = LoggerFactory.getLogger(getClass());
            logger.error("user doesn't exist .....",e);
            return user;
        }
        List<Authority> authorities = authorityService.findByUserId(user.getId());
        user.setAuthorities(authorities);
        return user;
    }


}
