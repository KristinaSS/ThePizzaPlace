create table PIZZAPLACE_DELIVERED_ORDER_LINK (
    DELIVERED_ID varchar(36) not null,
    ORDER_ID varchar(36) not null,
    primary key (DELIVERED_ID, ORDER_ID)
);
