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

-- Группировки
SELECT company.name
FROM company
         /*
             LEFT JOIN employee e ON company.id = e.company_id - Этот оператор объединяет таблицу company с таблицей employee посредством LEFT JOIN.
             LEFT JOIN возвращает все записи из левой таблицы (company) и сопоставленные записи из правой таблицы (employee).
             Если сопоставление отсутствует, результат будет содержать NULL на месте столбцов правой таблицы.
             Объединение происходит по условию company.id = e.company_id, то есть записи из employee присоединяются к записям из company,
             если идентификатор компании в обеих таблицах совпадает.
         */
         LEFT JOIN employee e
                   ON company.id = e.company_id
-- WHERE используется для каждой из строк
-- WHERE company.name = 'HissInc'

/*
    GROUP BY company.id - Этот оператор используется для группировки результата по одному или нескольким столбцам.
    В данном случае группировка происходит по company.id. Это значит, что данные будут сгруппированы по идентификатору компании,
    и для каждой компании будет рассчитано количество сотрудников (используя COUNT(e.id)).
    GROUP BY необходим, потому что функция агрегирования COUNT() используется для подсчета количества строк в каждой группе.
*/
GROUP BY company.id
-- Условие именно для группы
HAVING count(e.id) > 0;
