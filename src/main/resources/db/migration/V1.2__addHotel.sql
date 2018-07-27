create sequence hotel_id_seq;



create table Hotel(

id bigint not NULL DEFAULT NEXTVAL('hotel_id_seq'),
city varchar (225),
state varchar (225),
email varchar (225),
contact_phone varchar (225),
star_level varchar (225),

primary key (id)



)
