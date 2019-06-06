alter table PIZZAPLACE_ORDER add column FINAL_AMOUNT varchar(255) ^
update PIZZAPLACE_ORDER set FINAL_AMOUNT = '' where FINAL_AMOUNT is null ;
alter table PIZZAPLACE_ORDER alter column FINAL_AMOUNT set not null ;
alter table PIZZAPLACE_ORDER add column DISCOUNT decimal(19, 2) ^
update PIZZAPLACE_ORDER set DISCOUNT = 0 where DISCOUNT is null ;
alter table PIZZAPLACE_ORDER alter column DISCOUNT set not null ;
