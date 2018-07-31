package com.hotelgo.api.v1;

import com.google.common.collect.Lists;
import com.hotelgo.domain.User;
import com.hotelgo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = {"/api/users","/api/user"},produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {


    public final Logger logger = LoggerFactory.getLogger(getClass());
    public UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUserList() {
        logger.debug("list users");
        List<User> result = Lists.newArrayList(userRepository.findAll());;
        return result;
    }

}
