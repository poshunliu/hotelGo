package com.hotelgo.domain;



import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.SEQUENCE;


@Entity
@Table(name="room_types")
public class RoomType implements Serializable {

    @Id
    @Column(name="type_id")
    @GeneratedValue(strategy=SEQUENCE, generator="room_types_id_seq")
    @SequenceGenerator(name="room_types_id_seq", sequenceName="room_types_id_seq", allocationSize=1)
    private long TypeId;

    @Column(name="room_name")
    private String roomName;
    @Column(name="max_guest")
    private Integer maxGuest;
    @Column(name="room_price")
    private Integer roomPrice;
    @Column(name="description")
    private String description;

    public long getTypeId() {
        return TypeId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Integer getMaxGuest() {
        return maxGuest;
    }

    public void setMaxGuest(Integer maxGuest) {
        this.maxGuest = maxGuest;
    }

    public Integer getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(Integer roomPrice) {
        this.roomPrice = roomPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
