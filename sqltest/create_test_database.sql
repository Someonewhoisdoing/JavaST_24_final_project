CREATE DATABASE testdb;

--privileges
GRANT ALL PRIVILEGES ON testdb.* TO 'olya'@'localhost';

SHOW GRANTS FOR 'olya'@'localhost';

FLUSH PRIVILEGES;