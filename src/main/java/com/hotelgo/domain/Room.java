//package com.hotelgo.domain;
//
//
//import javax.persistence.*;
//
//import static javax.persistence.GenerationType.SEQUENCE;
//
//@Entity
//@Table(name="room_record")
//
//public class Room {
//
//    @javax.persistence.Id
//    @GeneratedValue(strategy=SEQUENCE, generator="room_id_seq")
//    @SequenceGenerator(name="room_id_seq", sequenceName="room_id_seq", allocationSize=1)
//    private long Id;
//
//
//
//    @Column (name ="room_type")
//    private String room_type;
//
//
//    public long getId() {
//        return Id;
//    }
//
//
//    public String getRoom_type() {
//        return room_type;
//    }
//
//    public void setRoom_type(String room_type) {
//        this.room_type = room_type;
//    }
//}
