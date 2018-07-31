package com.hotelgo.domain;



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


    public long getId() {
        return Id;
    }


    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
}
