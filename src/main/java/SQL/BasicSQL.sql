
SHOW schemas;

USE zipcode;

SHOW tables;

SELECT *
FROM customers;

SELECT COUNT(*)
FROM customers;

DESCRIBE customers:

SELECT id, ssn, name, acct_id
FROM customers;

SELECT acct_id, acct_num
FROM accounts;

SELECT id, ssn, name, acct_id, acct_num
FROM customers
         LEFT JOIN accounts
                   ON customers.acct_id = accounts.acct_id;

SELECT id, ssn, name, acct_id, acct_num
FROM customers
RIGHT JOIN accounts
ON customers.acct_id = accounts.acct_id;


-- an outer join is either a right or left join - it allows for rows to be returned where no matches have been found
