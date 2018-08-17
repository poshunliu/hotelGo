package com.hotelgo.api.v1;

import com.hotelgo.domain.User;
import com.hotelgo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = {"/api/users","/api/user"},produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    public final Logger logger = LoggerFactory.getLogger(getClass());

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


    @RequestMapping(method = RequestMethod.GET,params={"username"})
    @ResponseBody
    public User findByname( @RequestParam("username") String username   ){
        logger.debug("get user by name");
        User result = userService.findBy(username);
        return result;
    }


    @RequestMapping(method = RequestMethod.GET,params={"email"})
    @ResponseBody
    public User findByEmail(@RequestParam("email") String email){
        logger.debug("get user by email");
        User result = userService.findByEmail(email);
        return result;
    }


    @RequestMapping(name="/signup",method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public User saveUser(@RequestBody User user){
        logger.debug("save the user");
        User result = userService.save(user);
        return result;
    }



























}
