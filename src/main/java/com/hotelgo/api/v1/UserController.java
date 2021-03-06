package com.hotelgo.api.v1;

import com.hotelgo.domain.JsView;
import com.hotelgo.domain.User;
import com.hotelgo.extend.security.JwtTokenUtil;
import com.hotelgo.extend.security.RestAuthenticationRequest;
import com.hotelgo.extend.security.RestAuthenticationToken;
import com.hotelgo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import sun.tools.jstat.Token;

import javax.xml.ws.Response;
import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping(value = {"/api/users","/api/user"},produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController extends BaseController{
    public final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public UserService userService;
    @Autowired
    public AuthenticationManager authenticationManager;
    @Autowired
    public JwtTokenUtil jwtTokenUtil;


    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUserList() {
        setJsonViewClass(JsView.Other.class);
        disableMapperFeature_DEFAULT_VIEW_INCLUSION();
        logger.debug("list users.");
        List<User> result = userService.findAll();
        return result;
    }

    @RequestMapping(value= "/{Id}",method = RequestMethod.GET)
    @ResponseBody
    public User findById(@PathVariable("Id") Long Id){
        setJsonViewClass(JsView.User.class);
        disableMapperFeature_DEFAULT_VIEW_INCLUSION();
        logger.debug("get user by id.");
        User result = userService.findById(Id);
        return result;
    }

    @RequestMapping(params = "username",method = RequestMethod.GET)
    @ResponseBody
    public User findByName( @RequestParam("username") String username) throws Exception {
        setJsonViewClass(JsView.User.class);
        disableMapperFeature_DEFAULT_VIEW_INCLUSION();
        logger.debug("get user by name.");
        User result = userService.findByName(username);
        return result;
    }

    @RequestMapping(params = "email", method = RequestMethod.GET)
    @ResponseBody
    public User findByEmail(@RequestParam("email") String email){
        setJsonViewClass(JsView.User.class);
        disableMapperFeature_DEFAULT_VIEW_INCLUSION();
        logger.debug("get user by email.");
        User result = userService.findByEmail(email);
        return result;
    }

    @RequestMapping(value="/signup",method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public User saveUser(@RequestBody User user){
        logger.debug("save the user.");
        User result = userService.register(user);
        return result;
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity userLogin (@RequestBody RestAuthenticationRequest restAuthenticationRequest, Device device){
        logger.info("current usernname"+ restAuthenticationRequest.getUsername());
        logger.info("current password"+ restAuthenticationRequest.getPassword());
        Authentication notFullyAuthenticated = new UsernamePasswordAuthenticationToken(restAuthenticationRequest.getUsername(), restAuthenticationRequest.getPassword());
        try {
            final Authentication authentication = authenticationManager.authenticate(notFullyAuthenticated);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            try {
                RestAuthenticationToken restAuthenticationToken = new RestAuthenticationToken();
                final UserDetails userDetails = userService.findByName(restAuthenticationRequest.getUsername());
                final String token = jwtTokenUtil.generateToken(userDetails, device);
                restAuthenticationToken.setToken(token);
//            HashMap<String, String> map = new HashMap<>();
//            map.put("token",token);
                return ResponseEntity.ok(restAuthenticationToken);
            } catch (Exception e) {
                logger.error("Login reject.",e);
                return null;
            }

        }catch (AuthenticationException ex){

            logger.error("authentication Error");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Username/Password is incorrect, Please try again ");
        }




    }


//---------------- IS bad way to do login API for @RequestParam ----------------


//    @RequestMapping(value = "/login",method = RequestMethod.POST)
//    @ResponseBody
//    public String userLogin (@RequestParam("username") String username,
//                             @RequestParam("password") String password, Device device){
//
//        logger.info("current usernname"+ username);
//        logger.info("current password"+ password);
//        Authentication notFullyAuthenticated = new UsernamePasswordAuthenticationToken(username, password);
//        final Authentication authentication = authenticationManager.authenticate(notFullyAuthenticated);
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        try {
//            final UserDetails userDetails = userService.findByName(username);
//            final String token = jwtTokenUtil.generateToken(userDetails, device);
//            return token;
//        } catch (Exception e) {
//            e.printStackTrace();
//            logger.error("login user.");
//            return null;
//        }
//    }


}
