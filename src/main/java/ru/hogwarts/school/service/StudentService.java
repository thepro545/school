package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final HashMap<Long, Student> students = new HashMap<>();
    private long genId = 0;

    public Student createStudent(Student student) {
        student.setId(++genId);
        students.put(genId, student);
        return student;
    }

    public Student getStudent(long id) {
        return students.get(id);
    }

    public Student updateStudent(Student student) {
        if (students.containsKey(student.getId())) {
            students.put(student.getId(), student);
            return student;
        }
        return null;
    }

    public Student removeStudent(Long id) {
        return students.remove(id);
    }

    public Collection<Student> getAll() {
        return students.values();
    }

    public List<Student> getStudentByAge(int age) {
        return getAll().stream()
                .filter(e -> e.getAge() == age)
                .collect(Collectors.toList());
    }
}
