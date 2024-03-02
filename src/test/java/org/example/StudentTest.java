package org.example;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StudentTest {
    private List<Student> students;

    @BeforeAll
    public void initClass() {
        students = new ArrayList<>();
        System.out.println("BeforeALl");
    }

    @BeforeEach
    private void initMethod() {
        Student student1 = new Student("John", 20);
        Student student2 = new Student("Alice", 22);
        students.add(student1);
        students.add(student2);
        System.out.println("BeforeEach");
    }
    @AfterEach
    public void cleanMethod() {
        students.clear();
        System.out.println("AfterEach");
    }
    @AfterAll
    public void cleanClass() {
        System.out.println("AfterAll");
    }

    @Test
    public void testMethod1TestDataCreation() {
        assertNotNull(students);
        assertEquals(2, students.size());
    }

    @Test
    public void testMethod2TestStudentEnrolment() {
        Student student = students.get(0);
        student.enrollCourse("Math");
        student.enrollCourse("Physics");
        assertEquals(2, student.getEnrolledCourses().size());
        assertEquals("Math", student.getEnrolledCourses().get(0));
        assertEquals("Physics", student.getEnrolledCourses().get(1));
    }

    @Test
    public void testMethod3TestStudentGrade() {
        Student student = students.get(0);
        student.setGrade("Math", "A");
        student.setGrade("Physics", "B");
        assertEquals("A", student.getGrade("Math"));
        assertEquals("B", student.getGrade("Physics"));
    }
}