# Write your MySQL query statement below
SELECT e1.name AS Employee
FROM Employee e1
WHERE e1.managerId IN (
    SELECT e2.id
    FROM Employee e2
    WHERE e2.salary < e1.salary
);

