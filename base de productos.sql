create schema proyectojava;
use proyectojava;
create table productos(
codigo varchar(20) not null primary key,
descripcion varchar(255) not null,
stock int not null,
precio double not null
);
insert into productos(codigo, descripcion, stock, precio)
values('235547745','Hidrolavadora',5, 10000);
insert into productos(codigo, descripcion, stock, precio)
values('564343','Microondas',2, 7000);
insert into productos(codigo, descripcion, stock, precio)
values('325675','Televisor',5, 1000);
insert into productos(codigo, descripcion, stock, precio)
values('86322','Aspiradora',5, 65000);
insert into productos(codigo, descripcion, stock, precio)
values('652346','Tostadora',5, 100);
insert into productos(codigo, descripcion, stock, precio)
values('54227','Taladro',1, 6000);