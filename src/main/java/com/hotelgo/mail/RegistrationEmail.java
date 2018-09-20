package com.hotelgo.mail;

import com.hotelgo.domain.User;

import java.io.Serializable;
import java.util.Map;

public class RegistrationEmail extends AbstractFreemarkerEmail{

    @Override
    protected String getMailSubject() {
        return "Please verify you email";
    }

    @Override
    protected void putValue(User user, Map<String, Serializable> root) {
        root.put("user", user);
    }


}
