package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.List;

public interface StudentService {

    Student createStudent(Student student);

    Student getStudent(long id);

    Student updateStudent(Student student);

    Student removeStudent(Long id);

    Collection<Student> getAll();

    List<Student> getStudentByAge(int age);
}