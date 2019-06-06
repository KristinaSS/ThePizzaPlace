update PIZZAPLACE_DISH_QUANTITY set QUANTITY = 0 where QUANTITY is null ;
alter table PIZZAPLACE_DISH_QUANTITY alter column QUANTITY set not null ;
