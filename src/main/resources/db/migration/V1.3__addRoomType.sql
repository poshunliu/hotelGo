create sequence room_types_id_seq;

create table room_types (
    type_id bigint not null DEFAULT NEXTVAL('room_types_id_seq'),
    room_name varchar (255),
    max_guest int,
    room_price int,
    description varchar (255),
    primary key (type_id)
)