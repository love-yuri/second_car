drop database if exists db_car;
create database db_car;
use db_car;

#用户信息
create table if not exists users
(
    id       int primary key auto_increment,
    username varchar(20) unique,
    password varchar(20) not null,
    money    double      not null default 10000000,
    manager  bool        not null default false
);

# 车辆品牌
create table if not exists car_brand
(
    id     int primary key auto_increment,
    name   varchar(50) not null unique,
    remark varchar(100)
);

# 车辆型号
create table if not exists car_model
(
    id       int primary key auto_increment,
    brand_id int,
    name     varchar(50) not null ,
    foreign key (brand_id) references car_brand (id) on delete cascade on update cascade
);

# 车辆信息
create table if not exists cars
(
    id                int primary key auto_increment,
    displacement      double      not null,
    registration_date date        not null,
    price             double,
    mileage           double,
    type_of_clutch    varchar(20) not null,
    release_date      date        not null,
    model_id          int,
    foreign key (model_id) references car_model (id) on delete cascade
);

create table if not exists collect
(
    id      int primary key auto_increment,
    user_id int,
    car_id  int,
    foreign key (user_id) references users (id) on delete cascade on update cascade ,
    foreign key (car_id) references cars (id) on delete cascade on update cascade
);

create table if not exists storehouse
(
    id      int primary key auto_increment,
    user_id int,
    car_id  int,
    foreign key (user_id) references users (id) on delete cascade on update cascade,
    foreign key (car_id) references cars (id) on delete cascade on update cascade
);

# 插入用户
INSERT INTO users (username, password)
VALUES ('john', 'john123'),
       ('emma', 'emma456'),
       ('alex', 'alex789'),
       ('sarah', 'sarah123'),
       ('michael', 'michael456'),
       ('lucy', 'lucy789'),
       ('david', 'david123'),
       ('olivia', 'olivia456'),
       ('william', 'william789'),
       ('sophia', 'sophia123'),
       ('root', 'root'),
       ('yuri', 'yuri');

# 更新管理员
update users
set manager = true
where username = 'root';
update users
set manager = true
where username = 'yuri';

-- 插入车辆品牌数据
INSERT INTO car_brand (id, name, remark)
VALUES (1, '奥迪', '德国汽车制造商'),
       (2, '宝马', '德国汽车制造商'),
       (3, '奔驰', '德国汽车制造商'),
       (4, '丰田', '日本汽车制造商'),
       (5, '本田', '日本汽车制造商'),
       (6, '日产', '日本汽车制造商');


-- 插入车辆型号数据
INSERT INTO car_model (id, brand_id, name)
VALUES (1, 1, '奥迪A4L'),
       (2, 1, '奥迪Q5'),
       (3, 2, '宝马3系'),
       (4, 2, '宝马X5'),
       (5, 3, '奔驰C级'),
       (6, 3, '奔驰GLC'),
       (7, 4, '丰田卡罗拉'),
       (8, 4, '丰田凯美瑞'),
       (9, 5, '本田雅阁'),
       (10, 5, '本田CR-V'),
       (11, 6, '日产轩逸'),
       (12, 6, '日产途乐');

-- 插入车辆信息数据
INSERT INTO cars (id, displacement, registration_date, price, mileage, type_of_clutch, release_date, model_id)
VALUES (1, 2.0, '2020-01-01', 250000, 10000, '自动', '2019-12-01', 1),
       (2, 2.5, '2019-05-15', 350000, 20000, '自动', '2019-04-01', 2),
       (3, 2.0, '2018-07-10', 280000, 15000, '自动', '2018-06-01', 3),
       (4, 3.0, '2019-11-20', 450000, 18000, '自动', '2019-10-01', 4),
       (5, 2.0, '2017-09-05', 220000, 30000, '自动', '2017-08-01', 5),
       (6, 2.5, '2016-03-12', 320000, 25000, '自动', '2016-02-01', 6),
       (7, 1.6, '2019-08-18', 180000, 22000, '自动', '2019-07-01', 7),
       (8, 2.0, '2018-12-05', 260000, 19000, '自动', '2018-11-01', 8),
       (9, 1.5, '2017-04-25', 150000, 35000, '自动', '2017-03-01', 9),
       (10, 2.0, '2019-10-10', 240000, 28000, '自动', '2019-09-01', 10),
       (11, 1.6, '2016-06-08', 130000, 40000, '自动', '2016-05-01', 11),
       (12, 2.8, '2015-01-15', 380000, 32000, '自动', '2014-12-01', 12);


-- 插入车辆信息数据（手动挡）
INSERT INTO cars (id, displacement, registration_date, price, mileage, type_of_clutch, release_date, model_id)
VALUES (13, 1.8, '2018-09-20', 120000, 40000, '手动', '2018-08-01', 7),
       (14, 2.2, '2017-11-05', 180000, 32000, '手动', '2017-10-01', 8),
       (15, 1.4, '2016-05-15', 90000, 50000, '手动', '2016-04-01', 9),
       (16, 1.6, '2019-10-25', 110000, 45000, '手动', '2019-09-01', 10),
       (17, 1.6, '2016-07-12', 80000, 60000, '手动', '2016-06-01', 11),
       (18, 2.0, '2014-12-28', 150000, 55000, '手动', '2014-11-01', 12),
       (19, 1.5, '2019-06-08', 95000, 48000, '手动', '2019-05-01', 7),
       (20, 1.8, '2018-08-15', 130000, 42000, '手动', '2018-07-01', 8),
       (21, 1.6, '2017-02-25', 70000, 55000, '手动', '2017-01-01', 9),
       (22, 1.4, '2019-09-10', 100000, 50000, '手动', '2019-08-01', 10);


-- 插入收藏数据
INSERT INTO collect (user_id, car_id)
VALUES (1, 1),
       (1, 3),
       (2, 2),
       (2, 5),
       (2, 8),
       (3, 4),
       (4, 6),
       (4, 9),
       (5, 11),
       (5, 12),
       (6, 14),
       (7, 16),
       (8, 18),
       (9, 20),
       (10, 22),
       (12, 1),
       (12, 2),
       (12, 3);

INSERT INTO storehouse (user_id, car_id)
VALUES (12, 1),
       (12, 2),
       (12, 3),
       (11,1);

create view view_CarsInfo as
select cars.id, car_brand.name 'brand_name', car_model.name 'model_name',
       displacement, price, release_date,mileage,registration_date, type_of_clutch
from cars, car_brand, car_model
where car_model.brand_id = car_brand.id
  and cars.model_id = car_model.id;


create table history(
    id int auto_increment primary key,
    user_id int,
    tag varchar(20)
);

