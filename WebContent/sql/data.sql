/*script to insert data into movie table-TYUC001*/
 insert into movie values
 (1,'Avatar',2356787934,'Yes','2017-03-15','Science Fiction','Yes'),
 (2,'The Avenger',1518812988,'Yes','2017-12-23','Superhero','No'),
 (3,'Titanic',2187463844,'Yes','2017-08-21','Romance','No'),   
 (4,'Jurrasic World',1671713208,'No','2017-07-02','Science Fiction','Yes'),
 (5,'Avengers: Endgame',2750760348,'Yes','2022-02-11','Superhero','Yes');
 
/*script to fetch data from movie table-TYUC001*/
select mo_id, mo_title,mo_box_office,mo_active,mo_date_of_launch from movie;


/*script to fetch data from movie table-TYUC002*/
mysql> select*from movie where mo_date_of_launch <=now() and mo_active='Yes';


/*script to fetch data from movie table-TYUC003*/
mysql> select*from movie where mo_id=1;
/*script to edit data in menu_item table-TYUC003*/
mysql> update movie set mo_title='Thor',mo_box_office=1234567890,mo_active='No',mo_date_of_launch='2016-02-12',mo_genre='Superhero',mo_has_teaser='No' where mo_id=3;

/*script to insert data in user table-TYUC004*/
mysql> insert into user values(1,'Ays'),(2,'Naddy');
/*script to insert data in favourites table-TYUC004*/
mysql> insert into favourites values(1,1,1),(2,1,3),(3,1,5);

/*script to fetch data from movie table-TYUC005*/
mysql> select mi.mo_id,mi.mo_title,mi.mo_box_office,mi.mo_active,mi.mo_date_of_launch,mi.mo_genre,mi.mo_has_teaser from movie mi inner join favourites ct on mi.mo_id=ct.fv_pr_id and ct.fv_us_id;
/*script to get number of favourites of all movie in favourites-TYUC005*/
mysql> select sum(mo_box_office) from movie inner join favourites on movie.mo_id=favourites.fv_pr_id and favourites.fv_us_id;

/*script to remove data from favourites-TYUC006*/
mysql> delete from favourites where fv_us_id=1 and fv_pr_id=1;
