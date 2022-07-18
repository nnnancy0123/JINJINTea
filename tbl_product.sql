create table tbl_product( 
  product_id character varying (10) not null
  , product_name character varying (100) not null
  , sort int
  , category_id  character varying (10) not null
  , price int not null
  , max_num int 
  , warehouse int not null
  , date_created timestamp (6) without time zone not null
  , date_modified timestamp (6) without time zone not null
  , primary key (product_id)
);
delete from tbl_product;
select * from tbl_product;
drop table tbl_product;

update tbl_product set product_name = '01', sort = 1, category = 'category ', price = '12', max_nom = 'maxnom', warehouse = '4,' where product_id = '0001';

select category_name from tbl_category;
