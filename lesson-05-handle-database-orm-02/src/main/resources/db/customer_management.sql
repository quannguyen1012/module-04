create database customer_management;

create table customer_management.customer (
    id int not null auto_increment,
    name varchar(45) default null,
    email varchar(45) default null,
    address varchar(45) default null,
    primary key (id)
);

insert into customer_management.customer(name, email, address) values
('Ty', 'ty@gmail.com', '21K NVT'),
('Teo', 'teo@gmail.com', '21K NVT'),
('To', 'to@gmail.com', '21K NVT'),
('Bin', 'bin@gmail.com', '21K NVT'),
('Bo', 'bo@gmail.com', '21K NVT')
;