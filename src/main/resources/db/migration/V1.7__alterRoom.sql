Alter Table rooms ADD column transaction_id bigint not null;

Alter Table rooms
ADD CONSTRAINT fk_rooms_transactions
FOREIGN KEY(transaction_id) REFERENCES rooms(Id);