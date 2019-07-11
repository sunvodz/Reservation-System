create table information(
store_id    varchar2(20) not null,
store_name     varchar2(100) not null,
location       varchar2(100) not null,
phone_number   varchar2(20) not null,
Type_of_food   varchar2(100) not null,
PRIMARY KEY(store_id)
);

create table customer(
customer_id        varchar2(100)  not null,
customer_name      varchar2(100) not null,
customer_numphone  varchar2(100) not null,
PRIMARY KEY(customer_id)
);

create table reservation(
queue      varchar2(20)  not null,
date_time  varchar2(20)  not null,
PRIMARY KEY(queue)
);

create table tableA(
table_status  varchar2(20) not null,
table_id  varchar2(20)       not null,
store_id  varchar2(20) not null,
PRIMARY KEY(table_id),
FOREIGN KEY(store_id)REFERENCES information(store_id)
);

create table admin(
admin       varchar2(100)  not null,
password     varchar2(100) not null,
PRIMARY KEY(admin)
);

create table bill(
table_id    varchar2(20) not null,
bill_id       varchar2(100)  not null,
queue         varchar2(20)  not null,
customer_id   varchar2(100)  not null,
time           varchar2(100)  not null,
PRIMARY KEY(bill_id),
FOREIGN KEY(table_id)REFERENCES tableA(table_id),
FOREIGN KEY(customer_id)REFERENCES customer(customer_id),
FOREIGN KEY(queue)REFERENCES reservation(queue)
);

create table accessA(
queue      varchar2(20)  not null,
store_id    varchar2(20) not null,
PRIMARY KEY(queue,store_id),
FOREIGN KEY(queue)REFERENCES reservation(queue),
FOREIGN KEY(store_id)REFERENCES information(store_id)
);

create table useA(
queue      varchar2(20)  not null,
customer_id        varchar2(20)  not null,
PRIMARY KEY(queue,customer_id),
FOREIGN KEY(queue)REFERENCES reservation(queue),
FOREIGN KEY(customer_id)REFERENCES customer(customer_id)
);

CREATE SEQUENCE reservation_seq 
MINVALUE 1
MAXVALUE 999999999999999999999999999
START WITH 1
INCREMENT BY 1
CACHE 999;

CREATE SEQUENCE bill_seq 
MINVALUE 1
MAXVALUE 999999999999999999999999999
START WITH 1
INCREMENT BY 1
CACHE 999;


