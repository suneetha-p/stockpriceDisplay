INSERT INTO STOCKPRICE(STOCK_SYMBOL,BIDPRICE,ASKPRICE,EVENT_TIME) VALUES ('D05:sgx',23.2,24.3,SYSTIMESTAMP);
INSERT INTO STOCKPRICE(STOCK_SYMBOL,BIDPRICE,ASKPRICE,EVENT_TIME) VALUES ('EE05:sgx',23.2,24.3,SYSTIMESTAMP);
INSERT INTO STOCKPRICE(STOCK_SYMBOL,BIDPRICE,ASKPRICE,EVENT_TIME) VALUES ('F05:sgx',23.2,24.3,SYSTIMESTAMP);
INSERT INTO STOCKPRICE(STOCK_SYMBOL,BIDPRICE,ASKPRICE,EVENT_TIME) VALUES ('G05:sgx',23.2,24.3,SYSTIMESTAMP);
INSERT INTO STOCKPRICE(STOCK_SYMBOL,BIDPRICE,ASKPRICE,EVENT_TIME) VALUES ('D05:sgx',2.2,24.3,SYSTIMESTAMP);
INSERT INTO STOCKPRICE(STOCK_SYMBOL,BIDPRICE,ASKPRICE,EVENT_TIME) VALUES ('EE05:sgx',2.2,24.3,SYSTIMESTAMP);
INSERT INTO STOCKPRICE(STOCK_SYMBOL,BIDPRICE,ASKPRICE,EVENT_TIME) VALUES ('F05:sgx',2.2,24.3,SYSTIMESTAMP);
INSERT INTO STOCKPRICE(STOCK_SYMBOL,BIDPRICE,ASKPRICE,EVENT_TIME) VALUES ('G05:sgx',2.2,24.3,SYSTIMESTAMP);

SELECT STOCK_SYMBOL ,AVG(BIDPRICE +ASKPRICE )  AS PRICE FROM STOCKPRICE  GROUP BY STOCK_SYMBOL
