alter table PIZZAPLACE_ORDER add constraint FK_PIZZAPLACE_ORDER_ON_DELIVERED foreign key (DELIVERED_ID) references PIZZAPLACE_DELIVERED(ID);
create index IDX_PIZZAPLACE_ORDER_ON_DELIVERED on PIZZAPLACE_ORDER (DELIVERED_ID);