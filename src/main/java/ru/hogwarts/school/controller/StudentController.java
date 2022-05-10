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

//    @GetMapping
//    public ResponseEntity getAllStudents(@RequestParam(required = false) Integer min,
//                                         @RequestParam(required = false) Integer max) {
//        if (min != null && max != null) {
//            return ResponseEntity.ok(studentService.findByAgeBetween(min, max));
//        }
//        return ResponseEntity.ok(studentService.getAll());
//    }

    @GetMapping("filter/{age}")
    public ResponseEntity<List<Student>> getStudentByAge(@PathVariable int age) {
        return ResponseEntity.ok(studentService.getStudentByAge(age));
    }
}
