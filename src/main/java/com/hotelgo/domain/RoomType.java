//package com.hotelgo.domain;
//
//import afu.org.checkerframework.checker.igj.qual.I;
//import org.springframework.data.annotation.Id;
//
//import javax.persistence.*;
//
//import static javax.persistence.GenerationType.SEQUENCE;
//
//
//@Entity
//@Table(name="RoomType")
//
//public class RoomType {
//
//
//    @Id
//    @GeneratedValue(strategy=SEQUENCE, generator="room_type_id_seq")
//    @SequenceGenerator(name="room_type_id_seq", sequenceName="room_type_id_seq", allocationSize=1)
//    private long TypeId;
//
//    @Column(name="room_type")
//    private String RoomName;
//    @Column(name="max_guest")
//    private Integer MaxGuest;
//    @Column(name="room_price")
//    private Integer RoomPrice;
//    @Column(name="description")
//    private String description;
//
//
//    public long getTypeId() {
//        return TypeId;
//    }
//
//    public void setTypeId(long typeId) {
//        TypeId = typeId;
//    }
//
//    public String getRoomName() {
//        return RoomName;
//    }
//
//    public void setRoomName(String roomName) {
//        RoomName = roomName;
//    }
//
//    public Integer getMaxGuest() {
//        return MaxGuest;
//    }
//
//    public void setMaxGuest(Integer maxGuest) {
//        MaxGuest = maxGuest;
//    }
//
//
//    public Integer getRoomPrice() {
//        return RoomPrice;
//    }
//
//    public void setRoomPrice(Integer roomPrice) {
//        RoomPrice = roomPrice;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//}
