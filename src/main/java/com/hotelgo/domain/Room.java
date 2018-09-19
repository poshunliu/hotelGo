package com.hotelgo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="rooms")
public class Room implements Serializable {

    @Id
    @GeneratedValue(strategy=SEQUENCE, generator="rooms_id_seq")
    @SequenceGenerator(name="rooms_id_seq", sequenceName="rooms_id_seq", allocationSize=1)
    private long Id;



    @Column (name ="room_type")
    private String roomType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    @JsonIgnoreProperties(value = { "rooms","images" })
    private Hotel hotel;


    public long getId() {
        return Id;
    }


    public String getRoomType() {
        return roomType;
    }


    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }


    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

}
