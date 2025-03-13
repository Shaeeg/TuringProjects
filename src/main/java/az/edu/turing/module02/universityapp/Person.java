package az.edu.turing.module02.universityapp;

import java.util.Objects;

public abstract class Person {
    private String fullName;
    private int age;
    private String id;

    Person(String fullName, int age, String id) {
        this.fullName = fullName;
        this.age = age;
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            System.out.println("Age cannot be negative");
            return;
        }
        this.age = age;

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(fullName, person.fullName) && Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, age, id);
    }

    @Override
    public String toString() {
        return "Person{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", id='" + id + '\'' +
                '}';
    }
}