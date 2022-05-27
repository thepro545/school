-- Составить первый JOIN-запрос, чтобы получить информацию обо всех студентах
-- (достаточно получить только имя и возраст студента) школы Хогвартс вместе с названиями факультетов.
--
-- Составить второй JOIN-запрос, чтобы получить только тех студентов, у которых есть аватарки.

SELECT s.name, s.age, f.name FROM student s JOIN faculty f on s.faculty_id = f.id;

SELECT s.* from student s join avatar a on s.id = a.student_id;