create table tbl_account (
  product_id character varying(10) not null
  , product_name character varying(100) not null
  , price integer not null
  , product_num integer not null
  , discount integer
  , primary key (product_id)
);

select * from tbl_account;
drop table tbl_account
select a.*,p.product_id from tbl_account a left join tbl_product p on p.product_id = a.product_id
order by  p.product_id asc;


select p.product_id,p.product_name,p.price,a.product_num,a.discount from tbl_product p left join tbl_account a on p.product_id = a.product_id
order by  p.product_id asc;

