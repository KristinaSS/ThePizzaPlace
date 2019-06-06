create table PIZZAPLACE_DISH_QUANTITY (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    DISH_ID varchar(36) not null,
    ORDER_ID varchar(36) not null,
    QUANTITY integer,
    --
    primary key (ID)
);