package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacultyService {
    private final HashMap<Long, Faculty> faculties = new HashMap<>();
    private long genId = 0;

    public Faculty createFaculty(Faculty faculty){
        faculty.setId(++genId);
        faculties.put(genId, faculty);
        return faculty;
    }

    public Faculty getFaculty(long id){
        return faculties.get(id);
    }

    public Faculty updateFaculty(Faculty faculty){
        if(faculties.containsKey(faculty.getId())){
            faculties.put(faculty.getId(), faculty);
            return faculty;
        }
        return null;
    }

    public Faculty removeFaculty(long id){
        return faculties.remove(id);
    }

    public Collection<Faculty> getAll() {
        return faculties.values();
    }

    public List<Faculty> getFacultyByColor(String color) {
        return getAll().stream()
                .filter(e -> e.getColor().equals(color))
                .collect(Collectors.toList());
    }
}
