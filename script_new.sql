drop schema if exists trial1 ;

create schema trial1;

use trial1;

create table users (
user_id bigint primary key unique not null,
l_name varchar(50) not null,
f_name varchar(50) not null,
e_mail varchar(50) unique not null,
passphrase varchar(50) not null,
phone varchar(10) unique not null,
rating float default 0,
rol enum('USER','MODERATOR') default 'USER',
picture blob,
banned boolean default(0)
);

insert into users (user_id, l_name, f_name, e_mail, passphrase, phone) values
( 1, "Bindea1", "Bogdan1", "test1@yahoo.com", "P@ssw0rd", "0756278234"),
( 2, "Bindea2", "Bogdan2", "test2@yahoo.com", "P@ssw0rd","0756279244");

insert into users (user_id, l_name, f_name, e_mail, passphrase, phone, rol) values
( 3, "BindeaMod", "BogdanMod", "mod@yahoo.com", "1234", "0756278233",'MODERATOR');

insert into users (user_id, l_name, f_name, e_mail, passphrase, phone, rol, banned) values
( 4, "BindeaBan", "BogdanBan", "ban@yahoo.com", "1234", "0756278213",'USER',1);

create table question (
question_id int primary key unique not null,
author bigint not null,
title varchar(50) not null,
text_question varchar(500) not null,
creation dateTime,
updated dateTime,
picture varchar(100),
rating int default(0),
foreign key (author) references users(user_id)
);

insert into question (question_id, author, title, text_question, creation) values
(1,1,"Title1","Lorem ipsum",now()),
(2,2,"Title2","LOrem ipsuuuum", now());

create table answer (
answer_id int primary key unique not null,
question_id int not null,
author bigint not null,
text_answer varchar(500) not null,
creation dateTime not null,
updated dateTime,
picture varchar(100),
rating int default(0),
foreign key (author) references users(user_id),
foreign key (question_id) references question(question_id)
);

insert into answer (answer_id,question_id,author,text_answer,creation) values
(1,1,2,"Answer1To1",now()),
(2,1,1,"Answer2To1",now()),
(3,2,1,"Answer1To2",now());

create table tags (
tag_id int not null auto_increment primary key,
title varchar(25) not null
);

create table question_tags (
	question_id int not null,
    tag_id int not null,
    primary key(question_id, tag_id),
    foreign key (question_id) references question (question_id),
    foreign key (tag_id) references tags (tag_id)
);

insert into tags values 
(1, "#stack"),
(2, "#overflow"),
(3,"#array"),
(4,"#stac2k"),
(5,"#exception");

insert into question_tags values 
(1,1),
(1,2),
(2,1);

create table vote_question (
vote_id int primary key auto_increment,
question_id int not null,
user_id bigint not null,
vote int,
check(vote=1 or vote=-1),
foreign key (question_id) references question(question_id),
foreign key (user_id) references users(user_id)
);

insert into vote_question (question_id, user_id , vote ) values 
(1,1,1);

create table vote_answer (
vote_id int primary key auto_increment,
answer_id int not null,
user_id bigint not null,
vote int,
check(vote=1 or vote=-1 or vote=0),
foreign key (answer_id) references answer(answer_id),
foreign key (user_id) references users(user_id)
);

select * from users; 
select * from question;
select * from answer;
select * from tags;