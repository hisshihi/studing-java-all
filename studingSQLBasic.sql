CREATE TABLE author
(
    id         SERIAL PRIMARY KEY,
    first_name VARCHAR(128) NOT NULL,
    last_name  VARCHAR(128) NOT NULL
);

CREATE TABLE book
(
    id        BIGSERIAL PRIMARY KEY,
    name      VARCHAR(128) NOT NULL,
    year      SMALLINT     NOT NULL,
    pages     SMALLINT     NOT NULL,
    author_id INT REFERENCES author (id) ON DELETE CASCADE
);


INSERT INTO author (first_name, last_name)
VALUES ('Leo', 'Tolstoy'),
       ('Fyodor', 'Dostoevsky'),
       ('Jane', 'Austen'),
       ('Mark', 'Twain'),
       ('Charles', 'Dickens'),
       ('J.K.', 'Rowling'),
       ('George', 'Orwell');

SELECT *
from author;


INSERT INTO book (name, year, pages, author_id)
VALUES ('War and Peace', 1869, 1225, 1),
       ('Anna Karenina', 1877, 864, 1),
       ('Crime and Punishment', 1866, 671, 2),
       ('The Brothers Karamazov', 1880, 824, 2),
       ('Pride and Prejudice', 1813, 432, 3),
       ('Sense and Sensibility', 1811, 409, 3),
       ('Adventures of Huckleberry Finn', 1884, 366, 4),
       ('The Adventures of Tom Sawyer', 1876, 274, 4),
       ('Great Expectations', 1861, 544, 5),
       ('A Tale of Two Cities', 1859, 448, 5),
       ('Harry Potter and the Philosopher’s Stone', 1997, 223, 6),
       ('1984', 1949, 328, 7);

/*
 4. Написать запрос, выбирающий: название книги, год и имя автора,
 отсортированные по году издания книги в возрасатющем порядке.
 Написать тот же запрос, но для убывающего порядка.
*/
SELECT name,
       year,
       (SELECT a.first_name || ' ' || a.last_name FROM author a WHERE a.id = author_id) author
FROM book
ORDER BY year;

SELECT name,
       year,
       (SELECT a.first_name || ' ' || a.last_name FROM author a WHERE a.id = author_id) author
FROM book
ORDER BY year DESC;

-- Написать кол-во книг у заданного автора.
SELECT count(*)
FROM book
WHERE author_id IN (SELECT id FROM author WHERE last_name = 'Rowling');

-- Написать запрос, выбирающий книги,
-- у которых кол-во страниц больше среднего кол-ва страниц по всем книгам.
SELECT *
FROM book
WHERE pages > (SELECT avg(pages) FROM book);

-- Написать запрос, выбирающий 5 самых старых книг
-- Дополнить запрос и посчитать суммарное количество страниц среди этих книг
SELECT sum(pages)
FROM (SELECT *
      FROM book
      ORDER BY year
      LIMIT 5) t;

-- Написать запрос, изменяющий количество страниц у одной из книг
UPDATE book
SET pages = pages + 10
WHERE id = 12
RETURNING name, year, pages;

-- Написать удаляющий автора, который написал самую большую книгу
DELETE
FROM book
WHERE author_id = (SELECT book.author_id
                   FROM book
                   WHERE pages = (SELECT max(pages) FROM book))
RETURNING *;

DELETE FROM author
WHERE id = 1
RETURNING *;