CREATE DATABASE coffeeshop;

--privileges
CREATE USER 'olya'@'localhost' IDENTIFIED BY '66613777';

GRANT ALL PRIVILEGES ON coffeeshop.* TO 'olya'@'localhost';

SHOW GRANTS FOR 'olya'@'localhost';

FLUSH PRIVILEGES;

-------------------------------------------------------------------
--REVOKE ALL PRIVILEGES, GRANT OPTION FROM 'olya'@'localhost';
--DROP USER 'olya'@'localhost';
--DROP DATABASE coffeeshop;
-------------------------------------------------------------------