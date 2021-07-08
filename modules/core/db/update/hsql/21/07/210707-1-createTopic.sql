create table BUDGET2_TOPIC (
    ID varchar(36) not null,
    --
    IPRB_ID varchar(36),
    NAME varchar(255),
    Q1 integer,
    Q2 integer,
    Q3 integer,
    Q4 integer,
    --
    primary key (ID)
);