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

    @Override
    public List<String> getAllNamesStartWithA(){
        logger.debug("getAllNamesStartWithA method is in progress");
        return studentRepository.findAll().stream()
                .map(Student::getName)
                .map(String::toUpperCase)
                .filter((n -> n.startsWith("A")))
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public int getAvgAge(){
        logger.debug("getAvgAge method is in progress");
        return (int) studentRepository.findAll().stream()
                .mapToInt(Student::getAge)
                .average()
                .orElse(0);
    }

    @Override
    public void getNamesThread(){
        logger.debug("getNamesThread method is in progress");
        doThread(1);
        doThread(2);

        new Thread(() -> {
            doThread(3);
            doThread(4);
        }).start();

        new Thread(() -> {
            doThread(5);
            doThread(6);
        }).start();

    }

    public final Object flag = new Object();
    @Override
    public void getNamesSyncThread(){
        logger.debug("getNamesSyncThread method is in progress");
        doThreadSync(1);
        doThreadSync(2);

        new Thread(() -> {
            doThreadSync(3);
            doThreadSync(4);
        }).start();

        new Thread(() -> {
            doThreadSync(5);
            doThreadSync(6);
        }).start();

    }

    private void doThread(long id){
            System.out.println(studentRepository.getById(id).getName());
    }

    private void doThreadSync(long id){
        synchronized (flag)
        {
            System.out.println(studentRepository.getById(id).getName());
        }
    }
}
