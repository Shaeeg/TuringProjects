package az.edu.turing.module02.universityapp;

import java.util.Arrays;
import java.util.Objects;

public class Student extends Person {
    private String major;
    private Course[] courses;
    private double[] grades;
    private int enrolledCourses;
    private String[] courseNames;

    Student(String fullName, int age, String id, String major, int courseCount, University university) {
        super(fullName, age, id);
        this.major = major;
        this.grades = new double[courseCount];
        this.courses = new Course[courseCount];
        this.courseNames = new String[courseCount];
        this.enrolledCourses = 0;
        university.addStudent(this);
    }

    public void enrollInCourse(Course course) {
        if (course == null) {
            return;
        }
        for (int i = 0; i < enrolledCourses; i++) {
            if (courses[i] == course) {
                System.out.println("Course is already enrolled");
                return;
            }
        }
        if (enrolledCourses >= courses.length) {
            System.out.println("Course count exceeds the limit of " + courses.length);
            return;
        }

        courses[enrolledCourses++] = course;

        boolean alreadyAdded = false;
        for (int i = 0; i < course.getStudents().length; i++) {
            if (course.getStudents()[i] == this) {
                alreadyAdded = true;
                break;
            }
        }

        if (!alreadyAdded) {
            course.addStudent(this);
        }
    }

    public double calculateGpa() {
        if (enrolledCourses == 0) {
            return 0.0;
        }
        double total = 0;
        for (double grade : grades) {
            total += grade;
        }
        return total / enrolledCourses;
    }

    public void updateGrades(int index, double grade) {
        if(grade < 0){
            System.out.println("Grade cannot be negative");
            return;
        }
        if (index >= grades.length) {
            System.out.printf("No such(%s) index", index);
            System.out.println();
            return;
        }

        this.grades[index] = grade;
    }

    public void updateGrades(Course course, double grade) {
        if(grade < 0){
            System.out.println("Grade cannot be negative");
            return;
        }
        for (int i = 0; i < courses.length; i++) {
            if (courses[i] != null && courses[i].equals(course)) {
                this.grades[i] = grade;
                return;
            }
        }
        System.out.println("Course not found");
    }

    public void printCourseNames() {
        for (int i = 0; i < enrolledCourses; i++) {
            System.out.println(courses[i].getCourseName());
        }
    }

    public double getGradeForCourse(Course course) {
        for (int i = 0; i < courses.length; i++) {
            if (courses[i] == course) {
                return grades[i];
            }
        }
        return 0.0;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double[] getGrades() {
        return grades;
    }

    public void setGrades(double[] grades) {
        this.grades = grades;
    }

    public Course[] getCourses() {
        return courses;
    }

    public void setCourses(Course[] courses) {
        this.courses = courses;
    }

    public int getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(int enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    public String[] getCourseNames() {
        return courseNames;
    }

    public void setCourseNames(String[] courseNames) {
        this.courseNames = courseNames;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return enrolledCourses == student.enrolledCourses && Objects.equals(major, student.major) && Objects.deepEquals(courses, student.courses) && Objects.deepEquals(grades, student.grades) && Objects.deepEquals(courseNames, student.courseNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), major, Arrays.hashCode(courses), Arrays.hashCode(grades), enrolledCourses, Arrays.hashCode(courseNames));
    }

    @Override
    public String toString() {
        return super.toString() +
                "fullName='" + getFullName() + '\'' +
                ", major='" + major + '\'' +
                ", enrolledCourses=" + enrolledCourses +  // Show how many courses the student is enrolled in
                '}';
    }

}