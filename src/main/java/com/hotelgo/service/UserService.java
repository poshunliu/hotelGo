package com.hotelgo.service;

import com.google.common.collect.Lists;
import com.hotelgo.domain.User;
import com.hotelgo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        List<User> list = Lists.newArrayList(userRepository.findAll());
        return list;
    }
    @Transactional
    public User findById(Long Id){
        Optional<User> option = userRepository.findById(Id);
        User user = option.get();
        return user;
    }
    @Transactional
    public User findBy(String username){
        Optional<User> option = userRepository.findByUserName(username);
        User user = option.get();
        return user;
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
