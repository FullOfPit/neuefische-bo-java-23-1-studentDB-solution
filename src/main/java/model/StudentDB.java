package model;

import java.util.Arrays;

public class StudentDB {

    Student[] students;

    public StudentDB() {
        this.students = new Student[0];
    }

    public StudentDB(Student[] students) {
        this.students = students;
    }

    public Student[] getAllStudents() {

        return this.students;
    }

    @Override
    public String toString() {
        return "StudentDB{" +
                "students=" + Arrays.toString(students) +
                '}';
    }

    public Student randomStudent() {

        int index = (int) (Math.random() * this.students.length);
        return this.students[index];
    }

    public Student[] addStudent(Student newStudent) {

        int previousNumberStudents = this.students.length;
        Student[] newStudentArray = new Student[previousNumberStudents + 1];

        for (int i = 0; i < this.students.length; i++) {
            newStudentArray[i] = this.students[i];
        }
        newStudentArray[previousNumberStudents] = newStudent;

        this.students = newStudentArray;
        return this.students;
    }

    public Student[] removeStudent(Student studentToRemove) {

        if (!isStudentRegistered(studentToRemove)) {
            return this.students;
        }

        Student[] newStudents = new Student[this.students.length - 1];

        int j = 0;
        for (int i = 0; i < this.students.length; i++) {
            if (!this.students[i].equals(studentToRemove)) {
                newStudents[j] = this.students[i];
                j++;
            }
        }

        students = newStudents;
        return this.students;
    }

    public boolean isStudentRegistered(Student studentToCheck) {

        for (int i = 0; i < this.students.length; i++) {
            if (this.students[i].equals(studentToCheck)) {
                return true;
            }
        }
        return false;
    }
}

