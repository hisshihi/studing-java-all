-- КОНСОЛЬ 1

-- Dirty Read
SELECT *
FROM aircraft;
-- Открываем тарнзацию
BEGIN;
-- Обновляем данные у одной транзакции
UPDATE aircraft
SET model = model || '-1'
WHERE id = 1;

SELECT * FROM aircraft WHERE id = 1;
-- Откатываем транзакцию
ROLLBACK;
-- Просмотр текущий уровень изолированности
SHOW TRANSACTION ISOLATION LEVEL;
-- Просмотр уровня изолированности по умолчанию
SHOW DEFAULT_TRANSACTION_ISOLATION;

-- КОНСОЛЬ 2

-- Dirty Read
SELECT * FROM aircraft;
-- Открываем тарнзацию
BEGIN;
-- Просматриваем, отображаются ли "грязные" данные
SELECT * FROM aircraft WHERE id = 1;
-- Завершаем транзацию
COMMIT;
-- Просмотр текущий уровень изолированности
SHOW TRANSACTION ISOLATION LEVEL;


-- КОНСОЛЬ 1

-- Non Repeatable Read
BEGIN;
SELECT *
FROM aircraft
WHERE id = 1;

UPDATE aircraft
SET model = model || '-1'
WHERE id = 1;

COMMIT;

BEGIN;

UPDATE aircraft
SET model = model || '-1'
WHERE id = 1;

COMMIT;

-- КОНСОЛЬ 2

-- Non Repeatable Read
BEGIN;
SELECT * FROM aircraft WHERE id = 1;
COMMIT;
-- Для того, чтобы избежать этой ошибки, нужно повысить уровень изолированности
-- Так будет сделан snap shot тех данных, которые сделаны в этой транзакции.
BEGIN TRANSACTION ISOLATION LEVEL REPEATABLE READ;


-- КОНСОЛЬ 1

-- Phantom Read

BEGIN;

SELECT count(*) FROM aircraft;

INSERT INTO aircraft(model) VALUES ('test');

COMMIT;

-- КОНСОЛЬ 2

-- Phantom Read

BEGIN;

SELECT count(*) FROM aircraft;

COMMIT;

BEGIN TRANSACTION ISOLATION LEVEL SERIALIZABLE ;