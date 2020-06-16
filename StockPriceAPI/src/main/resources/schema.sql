drop table if exists STOCK_PRICE CASCADE ;
 drop sequence if exists hibernate_sequence;

Create  table STOCKPRICE(id number(5,2) auto_increment primary key,STOCK_SYMBOL varchar2(100),bidPrice number(5,2),askPrice number(5,2),EVENT_TIME TIMESTAMP);