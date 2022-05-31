package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repositories.StudentRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentServiceImp implements StudentService {

    private final StudentRepository studentRepository;

    Logger logger = LoggerFactory.getLogger(StudentServiceImp.class);

    public StudentServiceImp(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudent(Student student) {
        logger.debug("createStudent method is in progress");
        return studentRepository.save(student);
    }

    @Override
    public Student getStudent(long id) {
        logger.debug("getStudent method is in progress");
        return studentRepository.findById(id).get();
    }

    @Override
    public Student updateStudent(Student student) {
        logger.debug("updateStudent method is in progress");
        return studentRepository.save(student);
    }

    @Override
    public void removeStudent(Long id) {
        logger.debug("removeStudent method is in progress");
        studentRepository.deleteById(id);
    }

    @Override
    public Collection<Student> getAll() {
        logger.debug("getAll (Student) method is in progress");
        return studentRepository.findAll();
    }

    @Override
    public List<Student> getStudentByAge(int age) {
        logger.debug("getStudentByAge method is in progress");
        return studentRepository.findAll().stream()
                .filter(e -> e.getAge() == age)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Student> findByAgeBetween(Integer min, Integer max) {
        logger.debug("findByAgeBetween method is in progress");
        return studentRepository.findByAgeBetween(min, max);
    }

    @Override
    public int getAllStudentsSql(){
        logger.debug("getAllStudentsSql method is in progress");
        return studentRepository.getAllStudentsSql();
    }

    @Override
    public float getAvgAgeStudents(){
        logger.debug("getAvgAgeStudents method is in progress");
        return studentRepository.getAvgAgeStudents();
    }

    @Override
    public List<Student> getLast5Students(){
        logger.debug("getLast5Students method is in progress");
        return studentRepository.getLast5Students();
    }
}
