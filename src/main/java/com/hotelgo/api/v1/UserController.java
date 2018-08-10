package com.hotelgo.api.v1;

import com.google.common.collect.Lists;
import com.hotelgo.domain.User;
import com.hotelgo.repository.UserRepository;
import com.hotelgo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.naming.Name;
import java.util.List;

@RestController
@RequestMapping(value = {"/api/users","/api/user"},produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    public final Logger logger = LoggerFactory.getLogger(getClass());
//    @Autowired
//    public UserRepository userRepository;
    @Autowired
    public UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUserList() {
        logger.debug("list users");
        List<User> result = userService.findAll();
        return result;
    }

    @RequestMapping(value= "/{Id}",method = RequestMethod.GET)
    @ResponseBody
    public User findById(@PathVariable("Id") Long Id){
        logger.debug("get user by id");
        User result = userService.findById(Id);
        return result;
    }

//    @RequestParam("getname")
    public User findByname(User user){
        logger.debug("get user by name");
        userService.findBy(user.getUsername());
        return user;
    }















}
