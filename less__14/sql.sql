drop database if exists hibernate;
create database hibernate;
use  hibernate;

CREATE TABLE `Cart` (
  `id` int(10) primary key NOT NULL AUTO_INCREMENT,
  `total` varchar(10) NOT NULL,
  `name` varchar(20) NOT NULL
);

CREATE TABLE `Item` (
  `id` int(10) primary key  NOT NULL AUTO_INCREMENT,
  `total` varchar(10) NOT NULL
);

CREATE TABLE  `Cart_item` (
  `cart_id` int(10)  NOT NULL,
  `item_id` int(10)  NOT NULL
);

alter table Cart_item add foreign key (cart_id) references Cart (id);
alter table Cart_item add foreign key (item_id) references Item (id);