package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repositories.FacultyRepository;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacultyServiceImp implements FacultyService {

    private final FacultyRepository facultyRepository;

    Logger logger = LoggerFactory.getLogger(FacultyServiceImp.class);

    public FacultyServiceImp(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override
    public Faculty createFaculty(Faculty faculty) {
        logger.debug("createFaculty method is in progress");
        return facultyRepository.save(faculty);
    }

    @Override
    public Faculty getFaculty(long id) {
        logger.debug("getFaculty method is in progress");
        return facultyRepository.findById(id).get();
    }

    @Override
    public Faculty updateFaculty(Faculty faculty) {
        logger.debug("updateFaculty method is in progress");
        return facultyRepository.save(faculty);
    }

    @Override
    public void removeFaculty(long id) {
        logger.debug("removeFaculty method is in progress");
        facultyRepository.deleteById(id);
    }

    @Override
    public Collection<Faculty> getAll() {
        logger.debug("getAll (Faculty) method is in progress");
        return facultyRepository.findAll();
    }

    @Override
    public List<Faculty> getFacultyByColor(String color) {
        logger.debug("getFacultyByColor method is in progress");
        return facultyRepository.findAll().stream()
                .filter(e -> e.getColor().equals(color))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Faculty> findByColor(String color){
        logger.debug("findByColor method is in progress");
        return facultyRepository.findByColorIgnoreCase(color);
    }

    @Override
    public Collection<Faculty> findByName(String name){
        logger.debug("findByName method is in progress");
        return facultyRepository.findByNameIgnoreCase(name);
    }

    @Override
    public String getTheLongestNameFaculty(){
        logger.debug("getTheLongestNameFaculty method is in progress");
        return facultyRepository.findAll().stream()
                .map(Faculty::getName)
                .max(Comparator.comparingInt(String::length))
                .orElse(null);
    }
}
