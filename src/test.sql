#上锁
lock TABLE TABLE_NAME1 read, TABLE_NAME2 write;

show OPEN tables;

unlock tables;

set autocommit = 0;