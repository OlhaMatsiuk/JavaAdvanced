drop database if exists magazine_shop;
create database magazine_shop;
use magazine_shop;

create table magazine(
	id int not null primary key auto_increment,
    title varchar(60) not null unique,
    category varchar(60) not null,
    price decimal(6,2) not null,
	publish_date date not null
);

create table user(
	id int not null primary key auto_increment,
    first_name varchar(90) not null,
    last_name varchar(100) not null,
	email varchar(50) not null unique,
    password varchar(10) not null,
    role varchar(10) not null
);

create table subscriptions(
	id int not null primary key auto_increment,
    user_id int not null,
    magazine_id int not null,
    status boolean default false,
    start date not null,
    duration int not null
);
alter table subscriptions add foreign key (user_id) references user (id);
alter table subscriptions add foreign key (magazine_id) references magazine (id);

select * from magazine;
select * from user;
select * from subscriptions;