package com.hotelgo.service;

import com.google.common.collect.Lists;
import com.hotelgo.domain.User;
import com.hotelgo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

    @Transactional
    public List<User> findAll(){

        List<User> list = null;
        list = Lists.newArrayList(userRepository.findAll());
        try {
            if(list == null) {throw new Exception("The User parameter cant be null");}

        } catch (Exception e) {

            e.printStackTrace();
        }
        return list;
    }
    @Transactional
    public User findById(Long Id){
        Optional<User> option = userRepository.findById(Id);
        User user = option.get();
        return user;
    }
    @Transactional
    public User findBy(String username) throws Exception {
        Optional<User> option = userRepository.findByUserName(username);
        User user = option.get();
        if(option==null){
            throw new Exception("can't find user by username: "+username);
        }else {
            return user;
        }
    }

    @Transactional
    public User register(User u){
        String password =u.getPassword();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String passwordEncoder = encoder.encode(password);
        u.setPassword(passwordEncoder);
        return userRepository.save(u);
    }

    @Transactional
    public User save(User u){
        return userRepository.save(u);
    }

    @Transactional
    public User findByEmail(String email){
        Optional <User> option = userRepository.findByEmail(email);
        User user = option.get();
        return user;
    }








}
