package com.hotelgo.service;

import com.hotelgo.domain.User;
import com.hotelgo.mail.RegistrationEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.HashMap;

@Service
public class EmailService {

    @Autowired
    private RegistrationEmail registrationEmail;


    @Transactional
    public void sendEmail(User user){

        HashMap<String, Serializable> hashMap = new HashMap<>();
        registrationEmail.confirmEmail(user,hashMap);

    }
}
