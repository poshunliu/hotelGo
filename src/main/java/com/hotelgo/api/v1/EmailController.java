package com.hotelgo.api.v1;



import com.hotelgo.domain.User;
import com.hotelgo.service.EmailService;
import com.hotelgo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = {"/api/email","/api/emails"},produces = MediaType.APPLICATION_JSON_VALUE)
public class EmailController {
    @Autowired
    private UserService userService;
    @Autowired
    private EmailService emailService;

    @RequestMapping(value = "/user/{Id}", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void sendEmail(@PathVariable("Id") Long id){

        User user = userService.findById(id);
        emailService.sendEmail(user);

    }
}
