# Write your MySQL query statement below
select 
p.firstName, p.lastName, a.city, a.state 
from person p 
left join address a 
on p.personId = a.personId;

#left join as person table needed at all times, even if address table record not present for that row.