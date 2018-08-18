Alter Table users ADD column password varchar(255) not null;

Alter Table users ADD column account_expired BOOLEAN DEFAULT FALSE;
