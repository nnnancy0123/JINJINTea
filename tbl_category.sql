create table tbl_category( 
  category_id character varying (10) not null
  , category_name character varying (100) not null
  , sort int
  , show_flg character varying (1) not null
  , del_flg character varying (1) not null
  , date_created timestamp (6) without time zone not null
  , date_modified timestamp (6) without time zone not null
  , primary key (category_id)
); 

 

drop table category; 
 

delete from tbl_category
where category_id = '0003'


update tbl_category
set category_name = 'FFFFF',
    sort = '',
	show_flg = ''
where category_id = '0003'

select * from tbl_category;

