-- begin BUDGET2_TOPIC
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
)^
-- end BUDGET2_TOPIC
-- begin BUDGET2_IPRB
create table BUDGET2_IPRB (
    ID varchar(36) not null,
    --
    IC_TAG varchar(255),
    Q1 integer,
    Q2 integer,
    Q3 integer,
    Q4 integer,
    --
    primary key (ID)
)^
-- end BUDGET2_IPRB
