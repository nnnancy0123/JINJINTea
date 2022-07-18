create table tbl_total(
    total_id int not null
  , total_amount int not null
  , discount int not null
  , customer_price int not null
  , change int not null
  , primary key (total_id)
);

select * from tbl_total;
drop table tbl_total;


select p.*,c.category_name from tbl_product p
left join tbl_category c
on p.category_id = c.category_id


