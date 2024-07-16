SELECT company.name,
       employee.first_name || employee.last_name fio
FROM employee,
     company
WHERE company_id = company.id;

/*
INNER JOIN или же JOIN
Используется для объединения групп данныъ в единый поток
*/
SELECT c.name,
       employee.first_name || ' ' || employee.last_name fio,
       ec.contact_id,
       c2.number || ' ' || c2.type contact
FROM employee
JOIN public.company c
    ON c.id = employee.company_id
JOIN employee_contact ec
    ON employee.id = ec.employee_id
JOIN contact c2
ON ec.contact_id = c2.id;

-- CROSS JOIN
/*
Используется когда к результату хотим добавить 1 строчку
*/
SELECT *
FROM company
CROSS JOIN (select count(*) FROM  employee) t;

-- INNER JOIN -> JOIN
-- CROSS JOIN
-- LEFT JOIN
-- RIGHT JOIN
-- FULL JOIN