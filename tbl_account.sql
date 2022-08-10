create table tbl_account (
  product_id character varying(10) not null
  , product_name character varying(100) not null
  , price integer not null
  , product_num integer not null
  , discount integer
  , primary key (product_id)
);
