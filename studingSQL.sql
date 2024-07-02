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
    id   INT,
    name VARCHAR(128),
    date DATE
);

-- Удаление таблицы
DROP TABLE public.company;

