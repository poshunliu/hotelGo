create sequence room_type_id_seq;

create table RoomType(

    TypeId bigint not null DEFAULT NEXTVAL('room_type_id_seq'),
    RoomName varchar (255),
    MaxGuest int,
    RoomPrice int,
    description varchar (255),

    primary key (TypeId)
)