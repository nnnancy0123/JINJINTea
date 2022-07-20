create table "public".tbl_product (
  product_id character varying(10) not null
  , product_name character varying(100) not null
  , sort integer
  , category_id character varying(10) not null
  , price integer not null
  , max_num integer
  , warehouse integer not null
  , date_created timestamp(6) without time zone not null
  , date_modified timestamp(6) without time zone not null
  , primary key (product_id)
);

select * from tbl_product;

select
  tbl_product.product_id
  , tbl_product.product_name
  , tbl_product.price
  , tbl_product.category_id
  , tbl_category.category_id 
from
  tbl_product 
  left join tbl_category 
    on tbl_product.category_id = tbl_category.category_id 
order by
  tbl_product.product_id asc;



