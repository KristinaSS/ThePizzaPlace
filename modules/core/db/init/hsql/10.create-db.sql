-- begin PIZZAPLACE_CUSTOMER
create table PIZZAPLACE_CUSTOMER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    EMAIL varchar(255) not null,
    NUMBER_OF_ORDERS integer not null,
    --
    primary key (ID)
)^
-- end PIZZAPLACE_CUSTOMER
-- begin PIZZAPLACE_INGREDIENTS
create table PIZZAPLACE_INGREDIENTS (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    --
    primary key (ID)
)^
-- end PIZZAPLACE_INGREDIENTS
-- begin PIZZAPLACE_ORDER
create table PIZZAPLACE_ORDER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    CUSTOMER_ID varchar(36),
    NAME varchar(255) not null,
    ADDRESS varchar(255) not null,
    TELEPHONE_NUMBER varchar(255) not null,
    ORDER_TIME timestamp not null,
    TOTAL_AMOUNT decimal(19, 2),
    DISCOUNT decimal(19, 2) not null,
    FINAL_AMOUNT decimal(19, 2) not null,
    IS_DELIVERED boolean,
    DELIVERY_TIME timestamp,
    SPECIAL_DELIVERY_INSTRUCTIONS longvarchar,
    --
    primary key (ID)
)^
-- end PIZZAPLACE_ORDER
-- begin PIZZAPLACE_DISH_TYPE
create table PIZZAPLACE_DISH_TYPE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    --
    primary key (ID)
)^
-- end PIZZAPLACE_DISH_TYPE
-- begin PIZZAPLACE_DISH
create table PIZZAPLACE_DISH (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    PRICE decimal(19, 2) not null,
    DISH_TYPE_ID varchar(36) not null,
    DISH_SIZE varchar(50),
    --
    primary key (ID)
)^
-- end PIZZAPLACE_DISH
-- begin PIZZAPLACE_ORDER_DISH_LINK
create table PIZZAPLACE_ORDER_DISH_LINK (
    DISH_ID varchar(36) not null,
    ORDER_ID varchar(36) not null,
    primary key (DISH_ID, ORDER_ID)
)^
-- end PIZZAPLACE_ORDER_DISH_LINK
-- begin PIZZAPLACE_DISH_INGREDIENTS_LINK
create table PIZZAPLACE_DISH_INGREDIENTS_LINK (
    DISH_ID varchar(36) not null,
    INGREDIENTS_ID varchar(36) not null,
    primary key (DISH_ID, INGREDIENTS_ID)
)^
-- end PIZZAPLACE_DISH_INGREDIENTS_LINK
-- begin PIZZAPLACE_DISH_QUANTITY
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
    QUANTITY decimal(19, 2) not null,
    --
    primary key (ID)
)^
-- end PIZZAPLACE_DISH_QUANTITY
