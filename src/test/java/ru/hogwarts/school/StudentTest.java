package ru.hogwarts.school;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repositories.StudentRepository;
import ru.hogwarts.school.service.StudentServiceImp;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static ru.hogwarts.school.StudentData.*;

@ExtendWith(MockitoExtension.class)
public class StudentTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImp out ;

    @Test
    public void checkCreateStudent() {
//        Student actual = out.createStudent(NAME_AND_AGE1);
//        assertEquals(1, out.getAll().size());
//        assertTrue(out.getAll().contains(actual));
        when(out.createStudent(NAME_AND_AGE1))
                .thenReturn(NAME_AND_AGE1);
    }

    @Test
    public void getStudent() {
//        Student exist = out.createStudent(NAME_AND_AGE1);
//        assertEquals(1, out.getAll().size());
//        assertEquals(out.getStudent(1), exist);
        when(out.createStudent(NAME_AND_AGE1))
                .thenReturn(NAME_AND_AGE1);
        when(out.getStudent(ID_1))
                .thenReturn(NAME_AND_AGE1);
    }

    @Test
    public void removeStudent() {
        Student exist = out.createStudent(NAME_AND_AGE1);
        assertEquals(1, out.getAll().size());
        assertTrue(out.getAll().contains(exist));
        out.removeStudent(1L);
        assertTrue(out.getAll().isEmpty());
        assertFalse(out.getAll().contains(exist));
//        doThrow(RuntimeException.class).when(out.removeStudent(ID_1));
    }

    @Test
    public void getAll() {
//        Student student1 = out.createStudent(NAME_AND_AGE1);
//        Student student2 = out.createStudent(NAME_AND_AGE2);
//        Collection<Student> exist = List.of(student1, student2);
//        Collection<Student> actual = out.getAll();
//        assertIterableEquals(exist, actual);
        when(out.getAll()).thenReturn(STUDENTS_BOTH);
    }

    @Test
    public void getStudentByAge() {
//        Student student1 = out.createStudent(NAME_AND_AGE1);
//        assertEquals(1, out.getAll().size());
//        assertEquals(student1, out.getStudentByAge(AGE_1));
        when(out.getAll()).thenReturn(STUDENTS_BOTH);
        assertEquals(NAME_AND_AGE1, out.getStudentByAge(AGE_1));
    }

    @Test
    public void checkCollectionWhenDontExist() {
        assertIterableEquals(emptyList(), out.getAll());
    }
}
