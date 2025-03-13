package az.edu.turing.module02.universityapp;

import java.util.Arrays;
import java.util.Objects;

public class Course {
    private int courseCode;
    private String courseName;
    private Professor professor;
    private Student[] students;
    private int studentCount;

    Course(int courseCode, String courseName, Professor professor, int stCount, University university) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.professor = professor;
        this.students = new Student[stCount];
        this.studentCount = 0;
        university.addCourse(this);
    }

    public void addStudent(Student student) {
        if (studentCount >= students.length) {
            System.out.println("Course is full.");
            return;
        }
        students[studentCount++] = student;
        for (int i = 0; i < student.getCourses().length; i++) {
            if (student.getCourses()[i] == this) {
                return;
            }
        }
        student.enrollInCourse(this);
    }

    public double calculateCourseGpa() {
        if (studentCount == 0) {
            return 0.0;
        }
        double totalGpa = 0;
        for (Student student : students) {
            if (student != null) {
                totalGpa += student.calculateGpa();
            }
        }
        return totalGpa / studentCount;
    }

    public int getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(int courseCode) {
        this.courseCode = courseCode;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return courseCode == course.courseCode && studentCount == course.studentCount && Objects.equals(courseName, course.courseName) && Objects.equals(professor, course.professor) && Objects.deepEquals(students, course.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseCode, courseName, professor, Arrays.hashCode(students), studentCount);
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseCode=" + courseCode +
                ", courseName='" + courseName + '\'' +
                ", professor=" + professor +
                ", students=" + Arrays.toString(students) +
                ", studentCount=" + studentCount +
                '}';
    }
}
