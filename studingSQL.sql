-- Создание таблицы
CREATE DATABASE company_repository;

-- Создание схемы
CREATE SCHEMA company_storage;

-- Удаление схемы
DROP SCHEMA company_storage;

-- Создание таблицы и заполнение её полями
CREATE TABLE company
(
--     Описываем структуру таблицы
    id   INT PRIMARY KEY,
    name VARCHAR(128) UNIQUE NOT NULL,
    date DATE                NOT NULL CHECK ( date > '2000-01-01' AND date < '2024-07-03')
    -- Также можно указывать ограничения сразу по нескольким полям
--     PRIMARY KEY (id),
    -- Не можем вставить компания с одним и тем же названием и годом
--     UNIQUE (name, date)

-- NOT NULL - не может быть пустым
-- UNIQUE - поле должно быть уникальным
-- CHECK - ограничение к примеру по дате или кол-ву
-- PRIMARY KEY == UNIQUE NOT NULL - обозначает, что поле теперь первичный ключ
-- FOREIGN KEY - внешний ключ
    );

-- Удаление таблицы
DROP TABLE public.company;

-- Добавление записи в таблицу
INSERT INTO company(id, name, date)
VALUES (1, 'HissInc', '2024-07-02'),
       (2, 'Nvidia', '2002-10-18'),
       (3, 'OpenAI', '2013-08-10');

-- DROP TABLE employee;

CREATE TABLE employee
(
    id         SERIAL PRIMARY KEY,
    first_name VARCHAR(128) NOT NULL,
    last_name  VARCHAR(128) NOT NULL,
    company_id INT REFERENCES company (id),
    salary     INT,
    UNIQUE (first_name, last_name)
--     FOREIGN KEY (company_id) REFERENCES company
);

DROP TABLE employee;

INSERT INTO employee(first_name, last_name, salary, company_id)
VALUES ('Hiss', 'Dev', 10000, 1),
       ('Arina', 'Kovaleva', 9000, 1),
       ('Sergey', 'Ushakov', 7000, 3),
       ('Nikita', 'Gluharev', 6000, 2),
       ('Danila', 'Lebedev', 9000, NULL);

-- Выборка данных
-- DISTINCT - используется для выборки уникальных значений
SELECT DISTINCT id,
                first_name f_name,
                last_name  l_name,
                salary
FROM employee
-- LIKE Находим подстроку в строке
WHERE salary IN (5000, 10000)
   OR (first_name ILIKE 'a%'
    AND last_name LIKE '%ev')
-- Сортировка по какому-то значению
ORDER BY salary DESC
-- Показывает, что макс. кол-во записей - 2
-- LIMIT 2
-- Пропустить сколько-то записей
-- OFFSET 2
-- BETWEEN - диапазон
-- WHERE salary IN (5000, 10000) - найти конкретные значения
-- WHERE salary IN (5000, 10000) OR first_name ILIKE 'a%' - комбинация запросов, ищем по конкретной зарплате или по имени
;

-- Агрегирующие функции
-- sum, avg, max, min, count
-- sum - получение суммы чего-то
SELECT sum(employee.salary)
FROM employee;
-- avg - среднее значение
SELECT avg(employee.salary)
FROM employee;
-- count - получить кол-во строк
SELECT count(employee.salary)
FROM employee;
-- Конкатенация строк
SELECT upper(employee.first_name), concat(employee.first_name, ' ', employee.last_name) fio
FROM employee;
-- || тоже самое, что и конкат а now показывается текущую дату
SELECT upper(employee.first_name), employee.first_name || ' ' || employee.last_name fio, now()
FROM employee;