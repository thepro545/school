package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Faculty;

import java.util.Collection;
import java.util.List;

public interface FacultyService {
    Faculty createFaculty(Faculty faculty);

    Faculty getFaculty(long id);

    Faculty updateFaculty(Faculty faculty);

    void removeFaculty(long id);

    Collection<Faculty> getAll();

    List<Faculty> getFacultyByColor(String color);

    Collection<Faculty> findByColor(String color);

    Collection<Faculty> findByName(String name);
}
