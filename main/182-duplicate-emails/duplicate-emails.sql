# Write your MySQL query statement below
SELECT email
FROM Person
GROUP by email
HAVING COUNT(*) > 1