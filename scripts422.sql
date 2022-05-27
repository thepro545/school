-- Описание структуры: у каждого человека есть машина. Причем несколько человек могут пользоваться одной машиной.
--     У каждого человека есть имя, возраст и признак того, что у него есть права (или их нет).
--     У каждой машины есть марка, модель и стоимость. Также не забудьте добавить таблицам первичные ключи и связать их.

create table human
(
    id             integer PRIMARY KEY not null,
    "name"         varchar(30)         not null,
    age            integer             not null,
    driver_license boolean             not null,
    amount         integer             not null,
    car            integer             not null
);

create table car
(
    id     integer PRIMARY KEY not null,
    "name" varchar(30)         not null,
    model  varchar(30)         not null,
    price  money               not null,
    amount integer             not null,
    FOREIGN KEY (id) REFERENCES human (car)
)