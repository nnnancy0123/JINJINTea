create table tbl_ordernum (
  order_id character(32) not null
  , order_price integer not null
  , date_created timestamp(6) without time zone not null
  , date_modified timestamp(6) without time zone not null
  , primary key (order_id)
);
