package model;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class StudentDBTest {

    @Test
    public void getAllStudents_ReturnsStudentArray_WhenArrayProvidedInConstructor() {
        //Given
        Student testStudent = new Student("1", "a", 1, true);
        Student testStudentTwo = new Student("2", "b", 2, true);
        Student testStudentThree = new Student("3", "c", 3, false);

        StudentDB testStudentDB = new StudentDB(new Student[]{testStudent, testStudentTwo, testStudentThree});
        //When
        Student[] actual = testStudentDB.getAllStudents();
        //Then
        Assertions.assertArrayEquals(new Student[]{testStudent, testStudentTwo, testStudentThree}, actual);
    }

    @Test
    public void getAllStudents_ReturnsEmptyArray_WhenEmptyConstructor() {
        //Given
        StudentDB testStudentDB = new StudentDB();
        //When
        Student[] actual = testStudentDB.getAllStudents();
        //Then
        Assertions.assertArrayEquals(new Student[]{}, actual);
    }

    @Test
    public void addStudent_AddsStudentToLastPositionOfIndex_WhenStudentAdded() {
        //Given
        Student testStudent = new Student("1", "a", 1, true);
        Student testStudentTwo = new Student("2", "b", 2, true);
        Student testStudentThree = new Student("3", "c", 3, false);

        StudentDB testStudentDB = new StudentDB(new Student[]{testStudent, testStudentTwo});
        testStudentDB.addStudent(testStudentThree);
        //When
        Student actual = testStudentDB.students[2];
        //Then
        Assertions.assertEquals(testStudentThree, actual);
    }

    @Test
    public void addStudent_AddsStudent_IncreasesSizeOfArray() {
        //Given
        Student testStudent = new Student("1", "a", 1, true);
        Student testStudentTwo = new Student("2", "b", 2, true);
        Student testStudentThree = new Student("3", "c", 3, false);

        StudentDB testStudentDB = new StudentDB(new Student[]{testStudent, testStudentTwo});
        testStudentDB.addStudent(testStudentThree);
        //When
        int actual = testStudentDB.students.length;
        //Then
        Assertions.assertEquals(3, actual);
    }

    @Test
    public void isStudentRegistered_ReturnsTrue_WhenStudentRegistered() {
        //Given
        Student testStudent = new Student("1", "a", 1, true);
        StudentDB testStudentDB = new StudentDB(new Student[]{testStudent});
        //When
        boolean actual = testStudentDB.isStudentRegistered(testStudent);
        //Then
        Assertions.assertTrue(actual);
    }

    @Test
    public void isStudentRegistered_ReturnsFalse_WhenStudentNotRegistered() {
        //Given
        Student testStudent = new Student("1", "a", 1, true);
        Student testStudentTwo = new Student("2", "b", 2, true);
        StudentDB testStudentDB = new StudentDB(new Student[]{testStudent});
        //When
        boolean actual = testStudentDB.isStudentRegistered(testStudentTwo);
        //Then
        Assertions.assertFalse(actual);

    }

    @Test
    public void removeStudent_ReturnsArrayWithStudentRemoved() {
        //Given
        Student testStudent = new Student("1", "a", 1, true);
        Student testStudentTwo = new Student("2", "b", 2, true);
        Student testStudentThree = new Student("3", "c", 3, false);
        StudentDB testStudentDB = new StudentDB(new Student[]{testStudent, testStudentTwo, testStudentThree});
        //When
        Student[] actual = testStudentDB.removeStudent(testStudent);
        //Then
        //Spezielle Testmethode um Arrays auf Gleichheit zu testen
        Assertions.assertArrayEquals(new Student[]{testStudentTwo, testStudentThree} , actual);
    }

    @Test
    public void removeStudent_ReturnsPreviousArray_IfStudentNotRegistered() {
        //Given
        Student testStudent = new Student("1", "a", 1, true);
        Student testStudentTwo = new Student("2", "b", 2, true);
        Student testStudentThree = new Student("3", "c", 3, false);
        StudentDB testStudentDB = new StudentDB(new Student[]{testStudent, testStudentTwo});
        //When
        Student[] actual = testStudentDB.removeStudent(testStudentThree);
        //Then
        //Spezielle Testmethode um Arrays auf Gleichheit zu testen
        Assertions.assertArrayEquals(new Student[]{testStudent, testStudentTwo} , actual);
    }

    @Test
    public void removeStudent_OnEmptyArray_ReturnsEmptyArray() {
        //Given
        Student testStudent = new Student("1", "a", 1, true);
        StudentDB testStudentDB = new StudentDB(new Student[0]);
        //When
        Student[] actual = testStudentDB.removeStudent(testStudent);
        //Then
        //Spezielle Testmethode um Arrays auf Gleichheit zu testen
        Assertions.assertArrayEquals(new Student[]{}, actual);
    }

}