Alter Table rooms ADD column hotel_id bigint not null;

Alter table rooms
ADD CONSTRAINT fk_rooms_hotels
FOREIGN KEY(hotel_id) REFERENCES rooms(Id);





