package az.edu.turing.module02.universityapp;

import java.util.Arrays;
import java.util.Objects;

public class University {
    private String name;
    private Student[] people;
    private Course[] courses;
    private int studentCount;
    private int courseCount;

    University(String name, int studentCount, int courseCount) {
        this.name = name;
        this.people = new Student[studentCount];
        this.courses = new Course[courseCount];
        this.studentCount = 0;
        this.courseCount = 0;
    }

    public void addPeople(Student student) {
        if (studentCount >= people.length) {
            System.out.println("Student count exceeds the limit of " + people.length);
            return;
        }
        people[studentCount++] = student;
    }

    public void addCourse(Course course) {
        if (courseCount >= courses.length) {
            System.out.println("Course count exceeds the limit of " + courses.length);
            return;
        }
        courses[courseCount++] = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student[] getPeople() {
        return people;
    }

    public void setPeople(Student[] people) {
        this.people = people;
    }

    public Course[] getCourses() {
        return courses;
    }

    public void setCourses(Course[] courses) {
        this.courses = courses;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    public int getCourseCount() {
        return courseCount;
    }

    public void setCourseCount(int courseCount) {
        this.courseCount = courseCount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        University that = (University) o;
        return studentCount == that.studentCount && courseCount == that.courseCount && Objects.equals(name, that.name) && Objects.deepEquals(people, that.people) && Objects.deepEquals(courses, that.courses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, Arrays.hashCode(people), Arrays.hashCode(courses), studentCount, courseCount);
    }

    @Override
    public String toString() {
        return "University{" +
                "name='" + name + '\'' +
                ", people=" + Arrays.toString(people) +
                ", courses=" + Arrays.toString(courses) +
                ", studentCount=" + studentCount +
                ", courseCount=" + courseCount +
                '}';
    }
}