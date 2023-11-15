CREATE TABLE IF NOT EXISTS client(
user_id serial primary key,
first_name varchar(50) not null,
surname varchar(50) not null,
email varchar(50) not null,
balance numeric not null
);






