-- Создание таблицы
CREATE
DATABASE company_repository;

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
    date DATE                NOT NULL CHECK ( date > '2000-01-01' AND date < '2024-07-03'
) ,
-- Также можно указывать ограничения сразу по нескольким полям
    PRIMARY KEY (id),
    -- Не можем вставить компания с одним и тем же названием и годом
    UNIQUE (name, date)

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
       (2, 'Apple', '2002-10-18'),
       (3, 'OpenAI', '2013-08-10');

-- DROP TABLE employee;

CREATE TABLE employee
(
    id         SERIAL PRIMARY KEY,
    first_name VARCHAR(128) NOT NULL,
    last_name  VARCHAR(128) NOT NULL,
    salary     INT,
    UNIQUE (first_name, last_name)
);


INSERT INTO employee(first_name, last_name, salary)
VALUES ('Hiss', 'Dev', 10000),
       ('Arina', 'Kovaleva', 9000),
       ('Sergey', 'Ushakov', 7000);