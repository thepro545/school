package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Faculty;

import java.util.Collection;
import java.util.List;

public interface FacultyService {
    Faculty createFaculty(Faculty faculty);

    Faculty getFaculty(long id);

    Faculty updateFaculty(Faculty faculty);

    Faculty removeFaculty(long id);

    Collection<Faculty> getAll();

    List<Faculty> getFacultyByColor(String color);
}
