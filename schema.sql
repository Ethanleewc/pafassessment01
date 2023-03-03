create database acme_bank;

use acme_bank;

create table accounts(
account_id char(10) NOT NULL,
`name` varchar(100) NOT NULL,
balance DECIMAL(6,2) NOT NULL,
primary key (account_id)
);

insert into accounts (account_id, name, balance) values ('V9L3Jd1BBI', 'fred', '100.00');
insert into accounts (account_id, name, balance) values ('fhRq46Y6vB', 'barney', '300.00');
insert into accounts (account_id, name, balance) values ('uFSFRqUpJy', 'wilma', '1000.00');
insert into accounts (account_id, name, balance) values ('ckTV56axff', 'betty', '1000.00');
insert into accounts (account_id, name, balance) values ('Qgcnwbshbh', 'pebbles', '50.00');
insert into accounts (account_id, name, balance) values ('if9l185l18', 'bambam', '50.00');