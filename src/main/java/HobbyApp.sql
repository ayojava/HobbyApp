create table user 
(user_id bigint auto_increment,email varchar(40),username varchar(12),password varchar(60),primary key(user_id)) ;

create table userrole 
(role_id bigint auto_increment,user_id bigint not null,rolename varchar(20) not null,primary key (role_id),foreign key (user_id) references user (user_id));

create table userhobby 
(id bigint auto_increment,name varchar(40) not null,hobby varchar(40) not null,createdBy varchar(40) not null,createdOn DateTime not null,primary key (id));

insert into HobbyApp.user (user_id ,username, email , password) values(1,"admin","ayojava@gmail.com","admin");

insert into HobbyApp.userrole (role_id , user_id, rolename)values(1,1,"ADMIN");

