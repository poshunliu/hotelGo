package com.hotelgo.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="hotels")
public class Hotel implements Serializable{

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "hotels_id_seq")
    @SequenceGenerator(name = "hotels_id_seq", sequenceName = "hotels_id_seq", allocationSize = 1)
    private long Id;

    @Column(unique = true)
    @NotNull
    private String hotelName;


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

    @Column(name = "star_level" )
    private String star_level;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "hotel",cascade = CascadeType.ALL)
    private List<Room> rooms;




    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public long getId() {
        return Id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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


    public String getStar_level() {
        return star_level;
    }

    public void setStar_level(String star_level) {
        this.star_level = star_level;
    }


    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }
}


