-- База данных с авиаперелётами
-- CREATE DATABASE flight_repository;

-- аэропорт
CREATE TABLE airport
(
    code    CHAR(3) PRIMARY KEY,
    country VARCHAR(256) NOT NULL,
    city    VARCHAR(128) NOT NULL
);

CREATE TABLE aircraft
(
    id    SERIAL PRIMARY KEY,
    model VARCHAR(128) NOT NULL
);

CREATE TABLE seat
(
    aircraft_id INT REFERENCES aircraft (id),
    seat_no     VARCHAR(4) NOT NULL,
    PRIMARY KEY (aircraft_id, seat_no)
);

CREATE TABLE flight
(
    id                  BIGSERIAL PRIMARY KEY,
    flight_no           VARCHAR(16)                       NOT NULL,
    departure_date      TIMESTAMP                         NOT NULL,
    departure_date_code CHAR(3) REFERENCES airport (code) NOT NULL,
    arrival_date        TIMESTAMP                         NOT NULL,
    arrival_date_code   CHAR(3) REFERENCES airport (code) NOT NULL,
    aircraft_id         INT REFERENCES aircraft (id)      NOT NULL,
    status              VARCHAR(32)                       NOT NULL
);

CREATE TABLE ticket
(
    id             BIGSERIAL PRIMARY KEY,
    passenger_no   VARCHAR(32)                   NOT NULL,
    passenger_name VARCHAR(128)                  NOT NULL,
    flight_id      BIGINT REFERENCES flight (id) NOT NULL,
    seat_no        VARCHAR(4)                    NOT NULL,
    cost           NUMERIC(8, 2)                 NOT NULL
);


INSERT INTO airport (code, country, city)
VALUES ('SVO', 'Russia', 'Moscow'),
       ('LED', 'Russia', 'Saint Petersburg'),
       ('AER', 'Russia', 'Sochi');


INSERT INTO aircraft (model)
VALUES ('Sukhoi Superjet 100'),
       ('Airbus A320'),
       ('Boeing 737');


INSERT INTO seat (aircraft_id, seat_no)
SELECT id, s.column1
FROM aircraft
         CROSS JOIN (VALUES ('A1'), ('A2'), ('B1'), ('B2'), ('C1'), ('C2'), ('D1'), ('D2') ORDER BY 1) s;


INSERT INTO flight (flight_no, departure_date, departure_date_code, arrival_date, arrival_date_code, aircraft_id,
                    status)
VALUES ('SU100', '2023-12-20 09:00:00', 'SVO', '2023-12-20 11:00:00', 'LED', 1, 'Scheduled'),
       ('SU101', '2023-12-21 10:00:00', 'SVO', '2023-12-21 12:30:00', 'AER', 2, 'Scheduled');


INSERT INTO ticket (passenger_no, passenger_name, flight_id, seat_no, cost)
VALUES ('R001', 'Иван Иванов', 1, 'A1', 8000.00),
       ('R002', 'Мария Смирнова', 1, 'B1', 8000.00),
       ('R003', 'Дмитрий Кузнецов', 2, 'A2', 6500.00);

-- Кто летел позавчера рейсом Санкт-Петербург (LED) - Казань (KZN) на месте B1
SELECT *
FROM ticket
         JOIN flight f
              ON ticket.flight_id = f.id
WHERE seat_no = 'B1'
  AND f.departure_date_code = 'LED'
  AND f.arrival_date_code = 'KZN'
  AND f.departure_date::date = (now() - INTERVAL '2 days')::date;

-- Сколько мест осталось не занятыми 2024-07-15 на рейсе SU102?
SELECT t2.count - t1.count
FROM (SELECT f.aircraft_id, count(*)
      FROM ticket t
               JOIN flight f on f.id = t.flight_id
      WHERE f.flight_no = 'SU102'
        AND f.departure_date::date = '2024-07-15'
      GROUP BY f.aircraft_id) t1
         JOIN (SELECT aircraft_id, count(*)
               FROM seat
               WHERE aircraft_id = 3
               GROUP BY aircraft_id) t2
              ON t1.aircraft_id = t2.aircraft_id;

-- 2 вариант
-- Отобразить конкретные не занятые места
SELECT s.seat_no
FROM seat s
where aircraft_id = 1
  AND NOT EXISTS (SELECT t.seat_no
                  FROM ticket t
                           JOIN flight f on f.id = t.flight_id
                  WHERE f.flight_no = 'SU102'
                    AND f.departure_date::date = '2024-07-15'
                    AND s.seat_no = t.seat_no);

-- Какие 2 перелёта были самые длительные за всё время
SELECT f.id,
       f.arrival_date,
       f.arrival_date - f.departure_date
FROM flight f
ORDER BY (f.arrival_date - f.departure_date) DESC;

-- Какая максимальная продолжительность перелётов между
-- Минском и Лондоном и сколько всего было таких перелётов
SELECT MAX(f.arrival_date - f.departure_date) AS max_duration,
       COUNT(*)                               AS flight_count
FROM flight f
         JOIN
     airport a ON a.code = f.departure_date_code
         JOIN
     airport d ON d.code = f.arrival_date_code
WHERE a.city = 'Minsk'
  AND d.city = 'London';

-- Какие имена встречаются чаще всего
-- и какую долю составляются от общего кол-ва всех пассажиров
SELECT t.passenger_name,
       count(*),
       round(100.0 * count(*) / (SELECT count(*) FROM ticket), 2)
FROM ticket t
GROUP BY t.passenger_name
ORDER BY 2 DESC;

-- Вывести имена пассажиров, сколько всего каждый с таким именем купил билетов,
-- а также на сколько меньше от того имени пассажира, кто купил билетов больше всего
SELECT t1.*,
       first_value(t1.count) over () - t1.count
FROM (SELECT t.passenger_no,
             t.passenger_name,
             count(*)
      FROM ticket t
      GROUP BY t.passenger_no, t.passenger_name
      ORDER BY 3 DESC) t1;

-- Вывести стоимость всех маршрутов по убыванию
-- Отобразить разницу в стоимости между текущим и ближайшими в отсортированном списке маршрутами.
SELECT t1.*,
       COALESCE( lead(t1.sum_cost) over (ORDER BY t1.sum_cost), t1.sum_cost) - t1.sum_cost
FROM (SELECT t.flight_id,
             sum(t.cost) sum_cost
      FROM ticket t
      GROUP BY t.flight_id
      ORDER BY 2 DESC) t1;

