package com.hotelgo.domain;


import javax.persistence.*;
import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "images")
public class Image {

    @javax.persistence.Id
    @GeneratedValue(strategy = SEQUENCE, generator = "image_id_seq")
    @SequenceGenerator(name = "images_id_seq", sequenceName = "images_id_seq", allocationSize = 1)
    private Long Id;


    @Column(name = "url")
    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name  = "room_id")
    private Room room;



}
