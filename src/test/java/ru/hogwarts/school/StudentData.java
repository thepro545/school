package ru.hogwarts.school;

import ru.hogwarts.school.model.Student;

import java.util.Set;

public class StudentData {
    public static final String NAME_1 = "Имя1";
    public static final String NAME_2 = "Имя2";
    public static final int AGE_1 = 10;
    public static final int AGE_2 = 20;
    public static final long ID_1 = 1;
    public static final long ID_2 = 2;

    public static final Student NAME_AND_AGE1 = new Student(NAME_1, AGE_1);
    public static final Student NAME_AND_AGE2 = new Student(NAME_2, AGE_2);
    public static final Set<Student> STUDENTS_BOTH = Set.of(NAME_AND_AGE1, NAME_AND_AGE2);
}
