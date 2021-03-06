package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.List;

public interface StudentService {

    Student createStudent(Student student);

    Student getStudent(long id);

    Student updateStudent(Student student);

    void removeStudent(Long id);

    Collection<Student> getAll();

    List<Student> getStudentByAge(int age);

    Collection<Student> findByAgeBetween(Integer min, Integer max);

    int getAllStudentsSql();

    float getAvgAgeStudents();

    List<Student> getLast5Students();

    List<String> getAllNamesStartWithA();

    int getAvgAge();

    void getNamesThread();

    void getNamesSyncThread();
}
