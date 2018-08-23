package com.hotelgo.extend.security;

import com.hotelgo.domain.Authority;
import com.hotelgo.domain.User;
import com.hotelgo.service.AuthorityService;
import com.hotelgo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;
    @Autowired
    private AuthorityService authorityService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findBy(username);
        List<Authority> authorities = authorityService.findByUserId(user.getId());
        user.setAuthorities(authorities);
        return user;
    }


}
