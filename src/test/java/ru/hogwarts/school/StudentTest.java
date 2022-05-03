package ru.hogwarts.school;

import org.junit.jupiter.api.Test;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentServiceImp;

import java.util.Collection;
import java.util.List;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.*;
import static ru.hogwarts.school.StudentData.*;

public class StudentTest {
    StudentServiceImp out = new StudentServiceImp();

    @Test
    public void checkCreateStudent() {
        Student actual = out.createStudent(NAME_AND_AGE1);
        assertEquals(1, out.getAll().size());
        assertTrue(out.getAll().contains(actual));
    }

    @Test
    public void getStudent() {
        Student exist = out.createStudent(NAME_AND_AGE1);
        assertEquals(1, out.getAll().size());
        assertEquals(out.getStudent(1), exist);
    }

    @Test
    public void removeStudent() {
        Student exist = out.createStudent(NAME_AND_AGE1);
        assertEquals(1, out.getAll().size());
        assertTrue(out.getAll().contains(exist));
        Student actual = out.removeStudent(1L);
        assertEquals(exist, actual);
        assertTrue(out.getAll().isEmpty());
        assertFalse(out.getAll().contains(exist));
    }

    @Test
    public void getAll() {
        Student student1 = out.createStudent(NAME_AND_AGE1);
        Student student2 = out.createStudent(NAME_AND_AGE2);
        Collection<Student> exist = List.of(student1, student2);
        Collection<Student> actual = out.getAll();
        assertIterableEquals(exist, actual);
    }

    @Test
    public void getStudentByAge() {
        Student student1 = out.createStudent(NAME_AND_AGE1);
        assertEquals(1, out.getAll().size());
        assertEquals(student1, out.getStudentByAge(AGE_1));
    }

    @Test
    public void checkCollectionWhenDontExist() {
        assertIterableEquals(emptyList(), out.getAll());
    }
}
