Alter Table rooms
ADD CONSTRAINT fk_rooms_hotels
FOREIGN KEY(hotel_id) REFERENCES hotels(Id);