package model;

import java.util.Objects;

public class Student {

    String id;

    String name;
    int age;
    boolean partTime;

    public Student() {

    }

    public Student(String id, String name, int age, boolean partTime) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.partTime = partTime;
    }


    String getId() {
        return this.id;
    }

    String getName() {
        return this.name;
    }

    int getAge() {
        return this.age;
    }

    boolean getPartTime() {
        return this.partTime;
    }

    void setId(String id) {
        this.id = id;
    }

    void setName(String name) {
        this.name = name;
    }

    void setAge(int age) {
        this.age = age;
    }

    void setPartTime(boolean partTime) {
        this.partTime = partTime;
    }

    @Override
    public String toString() {
        return "model.Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", partTime=" + partTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return getAge() == student.getAge() && getPartTime() == student.getPartTime() && Objects.equals(getId(), student.id) && Objects.equals(getName(), student.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAge(), getPartTime());
    }
}
