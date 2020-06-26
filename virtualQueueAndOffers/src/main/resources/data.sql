INSERT INTO USER (id,username, password) values
(1,'sonia','sonia'),
(2,'chandler','chandler'),
(3,'joey shop','joey'),
(4,'monica store','monica');

INSERT INTO CUSTOMER(USER_ID,EMAIL,PHONE,NAME,HAS_VISA_CARD) values
(1,'sonia@gmail.com','123456789','sonia',TRUE),
(2,'chandler@gmail.com','123456789','joey',TRUE);

INSERT INTO MERCHANT(USER_ID, VISA_STORE_ID,VISA_MERCHANT_ID,MAX_STORE_CAPACITY,MAX_ALLOWING_CAPACITY,AVG_CUSTOMER_WAIT_TIME) values
(3,1,1,10,7,10),
(4,2,2,15,11,8);

INSERT  INTO QUEUE(QUEUE_ID,QUEUE_LEN,MERCHANT_ID,WAIT_TIME_IN_MINS,CURRENT_COUNT_IN_STORE) values
(1,0,3,10,3),
(2,10,4,50,20);


