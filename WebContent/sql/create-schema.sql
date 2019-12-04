/*create movie_cruiser database*/
create database if not exists movie_cruiser;

/*script to create change to movie_cruiser database*/
use movie_cruiser;

 
/*script to create user table*/
create table if not exists user(
us_id int auto_increment not null,
us_name varchar(60),
primary key(us_id));


/*script to create movie table*/
create table if not exists movie(
mo_id int auto_increment not null,
mo_title varchar(100),
mo_box_office bigint(15),
mo_active varchar(3),
mo_date_of_launch date,
mo_genre varchar(45),
mo_has_teaser varchar(3),
primary key(mo_id));

/*script to create favourites table*/
create table if not exists favourites(
fv_id int auto_increment not null,
fv_us_id int,
fv_pr_id int,
primary key(fv_id),
foreign key(fv_us_id) references user(us_id),
foreign key(fv_pr_id) references movie(mo_id)); 
