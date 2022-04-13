drop schema management_application_final;
create schema management_application_final;
use management_application_final;

create table if not exists clients(
clientId int auto_increment unique primary key,
clientName varchar(35),
clientSurname varchar(35),
clientAge int,
clientMail varchar(40));

create table if not exists orders(
orderId int auto_increment unique primary key,
orderSum int);

create table if not exists products(
productId int auto_increment unique primary key,
productName varchar(35),
productPrice float,
productStock int,
ordersId int);

insert into products(productName, productPrice, productStock) values("Orez",4.99,5);
insert into products(productName, productPrice, productStock) values("Banane",7.49,10);
insert into products(productName, productPrice, productStock) values("Lapte",5.19,20);

insert into clients(clientName, clientSurname, clientAge, clientMail) values("Rosca", "Sergiu",20,"roscasergiu@yahoo.com");
insert into clients(clientName, clientSurname, clientAge, clientMail) values("Ionescu", "Andrei",41,"andreiion12@yahoo.com");