create table tbl_product (
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
