-- begin BUDGET2_TOPIC
alter table BUDGET2_TOPIC add constraint FK_BUDGET2_TOPIC_ON_IPRB foreign key (IPRB_ID) references BUDGET2_IPRB(ID)^
create index IDX_BUDGET2_TOPIC_ON_IPRB on BUDGET2_TOPIC (IPRB_ID)^
-- end BUDGET2_TOPIC
