-- - Возраст студента не может быть меньше 16 лет.
-- - Имена студентов должны быть уникальными и не равны нулю.
-- - Пара “значение названия” - “цвет факультета” должна быть уникальной.
-- - При создании студента без возраста ему автоматически должно присваиваться 20 лет.

ALTER TABLE student ADD CONSTRAINT id check (age >16);
ALTER TABLE student ADD UNIQUE (name);
ALTER TABLE student ALTER COLUMN name SET not null;
ALTER TABLE faculty ADD CONSTRAINT id UNIQUE (name, color);
ALTER TABLE student ALTER COLUMN age SET DEFAULT 20;
