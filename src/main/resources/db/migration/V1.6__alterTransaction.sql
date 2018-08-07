Alter Table transactions
drop column user_id;

Alter Table transactions
add column user_id bigint not null;

Alter table transactions
ADD CONSTRAINT fk_transactions_users
FOREIGN KEY(user_id) REFERENCES transactions(id);



