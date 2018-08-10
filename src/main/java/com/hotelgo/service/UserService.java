package com.hotelgo.service;

import com.google.common.collect.Lists;
import com.hotelgo.domain.User;
import com.hotelgo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public List<User> findAll(){

        List<User> list = Lists.newArrayList(userRepository.findAll());

        return list;

    }


    public User findById(Long Id){
        Optional<User> option = userRepository.findById(Id);
        User user = option.get();
        return user;
    }


    public User findByName(String name){
        Optional<User> option = userRepository.findByName(name);
        User user = option.get();
        return user;
    }




}
