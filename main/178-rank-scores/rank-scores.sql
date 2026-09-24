# Write your MySQL query statement below
SELECT
 S1.score,
 (
    SELECT COUNT(DISTINCT S2.score)
    FROM Scores s2
    WHERE s2.score >= s1.score
 ) AS 'rank'
 FROM Scores s1
 ORDER BY s1.score DESC;