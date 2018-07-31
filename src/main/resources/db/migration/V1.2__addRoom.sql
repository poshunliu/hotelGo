create sequence rooms_id_seq;

create table rooms (
    id bigint not NULL DEFAULT NEXTVAL('rooms_id_seq'),
    room_type varchar(255),
    primary key(id)
)