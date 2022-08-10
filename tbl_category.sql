create table tbl_category (
  category_id character varying(10) not null
  , category_name character varying(100) not null
  , sort integer
  , show_flg character varying(1) not null
  , del_flg character varying(1) not null
  , date_created timestamp(6) without time zone not null
  , date_modified timestamp(6) without time zone not null
  , primary key (category_id)
);
