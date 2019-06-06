alter table PIZZAPLACE_ORDER alter column FINAL_AMOUNT rename to FINAL_AMOUNT__U77534 ^
alter table PIZZAPLACE_ORDER alter column FINAL_AMOUNT__U77534 set null ;
alter table PIZZAPLACE_ORDER add column FINAL_AMOUNT decimal(19, 2) ^
update PIZZAPLACE_ORDER set FINAL_AMOUNT = 0 where FINAL_AMOUNT is null ;
alter table PIZZAPLACE_ORDER alter column FINAL_AMOUNT set not null ;
