package com.hotelgo.domain;


import com.sun.prism.Image;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.awt.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="Hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "hotel_id_seq")
    @SequenceGenerator(name = "hotel_id_seq", sequenceName = "hotel_id_seq", allocationSize = 1)
    private long Id;


    @Column(name = "city")
    private String city;


    @Column(name = "state")
    private String state;


    @Column(unique = true)
    @NotNull
    private String email;


    @Column(unique = true)
    @NotNull
    private String contact_phone;

/*
    @Column (name = "true")
    private String star_level;*/


    public long getId() {
        return Id;
    }

    public String getState() {
        return state;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContact_phone() {
        return contact_phone;
    }

    public void setContact_phone(String contact_phone) {
        this.contact_phone = contact_phone;
    }
}


