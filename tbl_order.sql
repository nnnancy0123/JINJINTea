create table tbl_order (
  order_id character(32) not null
  , product_id character(32) not null
  , product_name character(255) not null
  , product_price integer not null
  , product_num integer not null
  , date_created timestamp(6) without time zone not null
  , date_modified timestamp(6) without time zone not null
);
