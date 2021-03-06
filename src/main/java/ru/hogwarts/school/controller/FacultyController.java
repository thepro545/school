package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyServiceImp;

import java.util.List;

@RestController
@RequestMapping("faculty")
public class FacultyController {
    private final FacultyServiceImp facultyService;

    public FacultyController(FacultyServiceImp facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Faculty> getFaculty(@PathVariable Long id) {
        Faculty faculty = facultyService.getFaculty(id);
        if (faculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);
    }

    @PostMapping
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return facultyService.createFaculty(faculty);
    }

    @PutMapping
    public ResponseEntity<Faculty> updateFaculty(@RequestBody Faculty faculty) {
        Faculty facultyDelete = facultyService.updateFaculty(faculty);
        if (facultyDelete == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(facultyDelete);
    }

    @DeleteMapping("{id}")
    public void removeFaculty(@PathVariable Long id) {
        facultyService.removeFaculty(id);
    }

    @GetMapping
    public ResponseEntity getAllFaculties(@RequestParam(required = false) String color,
                                          @RequestParam(required = false) String name) {
        if (color != null && !color.isBlank()) {
            return ResponseEntity.ok(facultyService.findByColor(color));
        }
        if (name != null && !name.isBlank()){
            return ResponseEntity.ok(facultyService.findByName(name));
        }
        return ResponseEntity.ok(facultyService.getAll());
    }


    @GetMapping("filter/{color}")
    public ResponseEntity<List<Faculty>> getFacultyByColor(@PathVariable String color) {
        return ResponseEntity.ok(facultyService.getFacultyByColor(color));
    }

    @GetMapping("filter/theLongestName")
    public ResponseEntity<String> getFacultyByColor() {
        return ResponseEntity.ok(facultyService.getTheLongestNameFaculty());
    }

}
