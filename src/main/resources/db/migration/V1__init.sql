create sequence users_id_seq;

create table users (
    id bigint not null DEFAULT NEXTVAL('users_id_seq'),
    username varchar (255) not null unique,
    first_name varchar(255),
    last_name varchar(255) not NULL,
    email varchar(225) not null unique,

    primary key (id)
);


