create table tbl_account(
  product_id character varying (10) not null
  , product_name character varying (100) not null
  , sort int
  , price int not null
  , product_num int not null
  , discount int 
  , primary key (product_id)
);
select * from tbl_account;
