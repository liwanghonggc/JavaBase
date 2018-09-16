#上锁
lock TABLE TABLE_NAME1 read, TABLE_NAME2 write;

show OPEN tables;

unlock tables;

set autocommit = 0;

alter table tableName add unique key uniq_key(field1, field2)