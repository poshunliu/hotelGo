create sequence images_id_seq;

create table images(
    id bigint not NULL DEFAULT NEXTVAL('images_id_seq'),
    url varchar (225),
    hotel_id bigint not null,
    room_id bigint not null,
    CONSTRAINT fk_images_hotels FOREIGN KEY(hotel_id) REFERENCES images(Id),
    CONSTRAINT fk_images_rooms FOREIGN KEY(room_id) REFERENCES images(Id),

    primary key (id)
)
