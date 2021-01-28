-- You have a table that contains employee_id as the primary key, a column called name, and another column called
-- called doj (date of join)
-- After a few years your boss wants to know who the third most senior person is based on doj

SELECT doj, GROUP_CONCAT(name SEPARATOR ', ') AS Employee_Names
FROM employ
GROUP BY doj
LIMIT 1 OFFSET 2;

-- What the code does is group the names (multiple employees could be hired on the same day) by the doj and retuns the
-- group of names in a column called Employee_Names
