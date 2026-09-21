# Write your MySQL query statement below
SELECT DISTINCT l1.num as ConsecutiveNums
FROM Logs l1
JOIN Logs l2 ON l1.id = l2.id - 1 AND l1.num = l2.num
JOIN Logs l3 ON L2.ID = L3.ID - 1 AND l2.num = l3.num;