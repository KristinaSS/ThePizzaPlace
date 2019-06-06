update PIZZAPLACE_ORDER set NAME = '' where NAME is null ;
alter table PIZZAPLACE_ORDER alter column NAME set not null ;
