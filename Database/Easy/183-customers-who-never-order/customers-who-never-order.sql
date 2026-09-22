# Write your MySQL query statement below
SELECT name AS Customers
FROM Customers AS a
LEFT JOIN Orders as b
ON a.id = b.customerId
WHERE b.customerId IS NULL;