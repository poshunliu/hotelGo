
create sequence transactions_id_seq;


create table transactions(
    id bigint not NULL DEFAULT NEXTVAL('transactions_id_seq'),
    tran_no int UNIQUE,
    user_id varchar (255),
    start_date varchar (255),
    end_date  varchar (255),
    total_payment int,
    payment_type varchar (255),
    primary key(id)


)
