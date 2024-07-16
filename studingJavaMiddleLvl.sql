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
       c2.number || ' ' || c2.type                      contact
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
         CROSS JOIN (select count(*) FROM employee) t;

/*
Для того, чтобы пройтись с помощью LEFT JOIN
Нам нужно определить, от какой таблицы будем идти
Потому что результирующий набор таблицы от которой будем идти
дудет содержать все записи этой таблицы

Т.е. будут отображены все записи слева от LEFT JOIN
*/
SELECT c.name,
       e.first_name || ' ' || e.last_name fio
FROM company c
         LEFT JOIN employee e
                   ON c.id = e.company_id;

-- Как допустим тут, не будет отображена компания, к которой не прикреплён сотрудник
SELECT c.name,
       e.first_name
FROM employee e
         LEFT JOIN company c ON e.company_id = c.id;

-- RIGHT JOIN делает то же самое, но отображается справа
SELECT c.name,
       e.first_name || ' ' || e.last_name fio
FROM company c
         RIGHT JOIN employee e
                    ON c.id = e.company_id
                        AND c.date > '2012-01-01';

/*
FULL JOIN
То же самое, но объединяет RIGHT AND LEFT и отображает все записи
*/
SELECT c.name,
       e.first_name || ' ' || e.last_name fio
FROM company c
         FULL JOIN employee e
                   ON c.id = e.company_id;

/*
CROSS JOIN
Не требудет объединение таблиц, потому что сам по себе объединяет и выводит все записи
*/
SELECT c.name,
       e.first_name
FROM company c
         CROSS JOIN employee e;
