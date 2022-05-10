package ru.hogwarts.school.repositories;

import org.hibernate.mapping.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.model.Faculty;

import java.util.Set;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    Set<Faculty> findByColorIgnoreCase(String color);
    Set<Faculty> findByNameIgnoreCase(String name);


}
