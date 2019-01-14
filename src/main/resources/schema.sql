create table article
(
   id integer not null AUTO_INCREMENT,
   title varchar(255) not null,
   intro varchar(255) not null,
   text varchar(255) not null,
   picture varchar(255) not null,
   pictureDescription varchar(255) not null,
   tags varchar(255) not null,
   primary key(id)
);
