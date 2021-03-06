package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentServiceImp;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {
    private final StudentServiceImp studentService;

    public StudentController(StudentServiceImp studentService) {
        this.studentService = studentService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        Student student = studentService.getStudent(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PutMapping
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        Student studentDelete = studentService.updateStudent(student);
        if (studentDelete == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentDelete);
    }

    @DeleteMapping("{id}")
    public void removeStudent(@PathVariable Long id) {
        studentService.removeStudent(id);
    }

    @GetMapping
    public ResponseEntity<Collection<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAll());
    }

    @GetMapping("between")
    public ResponseEntity getStudentsBetween(@RequestParam Integer min,
                                             @RequestParam Integer max) {
        return ResponseEntity.ok(studentService.findByAgeBetween(min, max));
    }


    @GetMapping("filter/{age}")
    public ResponseEntity<List<Student>> getStudentByAge(@PathVariable int age) {
        return ResponseEntity.ok(studentService.getStudentByAge(age));
    }

    @GetMapping("sql/getAll")
    public ResponseEntity getAllStudentsSql() {
        return ResponseEntity.ok(studentService.getAllStudentsSql());
    }

    @GetMapping("sql/getAvg")
    public ResponseEntity getAvgAgeStudents() {
        return ResponseEntity.ok(studentService.getAvgAgeStudents());
    }

    @GetMapping("sql/getLast5")
    public ResponseEntity<List<Student>> getLast5Students() {
        return ResponseEntity.ok(studentService.getLast5Students());
    }

    @GetMapping("nameWithA")
    public ResponseEntity<List<String>> getAllNamesStartWithA() {
        return ResponseEntity.ok(studentService.getAllNamesStartWithA());
    }

    @GetMapping("getAverageAge")
    public ResponseEntity<Integer> getAvgAge() {
        return ResponseEntity.ok(studentService.getAvgAge());
    }

    @GetMapping("getAllThread")
    public void getNamesThread() {
        studentService.getNamesThread();
    }

    @GetMapping("getAllThreadSync")
    public void getNamesSyncThread() {
        studentService.getNamesSyncThread();
    }

}
