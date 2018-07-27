create sequence room_id_seq;



create table Room(


id bigint not NULL DEFAULT NEXTVAL('room_id_seq'),
room_type varchar(255),

primary key(id)


)