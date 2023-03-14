drop schema if exists trial1 ;

create schema trial1;

use trial1;

create table users (
user_id int primary key unique not null,
l_name varchar(50) not null,
f_name varchar(50) not null,
e_mail varchar(50) unique not null,
phone varchar(10) unique not null,
rating float default 0,
rol enum('USER','MODERATOR') default 'USER'
);

insert into users (user_id, l_name, f_name, e_mail,phone) values

( 1, "Bindea1", "Bogdan1", "test1@yahoo.com", "0756278234");

create table content (
content_id int primary key unique not null,
author int not null,
title varchar(50),
text_content varchar(500) not null,
creation datetime not null,
picture varchar(100),
answer_id int,
foreign key (answer_id) references content(content_id)
);

create table tags (
tag varchar(20) not null,
question_id int not null,
foreign key (question_id) references content(content_id)
);

create table votes (
content_id int not null,
user_id int not null,
vote int,
check(vote=1 or vote=-1),
foreign key (content_id) references content(content_id),
foreign key (user_id) references users(user_id)
);

/* select * from users; */