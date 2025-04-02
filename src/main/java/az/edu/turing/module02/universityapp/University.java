package az.edu.turing.module02.universityapp;

import java.util.Arrays;
import java.util.Objects;

public class University {
    private String name;
    private Student[] students;
    private Professor[] professors;
    private Course[] courses;
    private int studentCount;
    private int professorCount;
    private int courseCount;

    University(String name, int studentCount, int courseCount, int professorCount) {
        this.name = name;
        this.students = new Student[studentCount];
        this.courses = new Course[courseCount];
        this.professors = new Professor[professorCount];
        this.studentCount = 0;
        this.courseCount = 0;
        this.professorCount = 0;
    }

    public void addStudent(Student student) {
        if (studentCount >= students.length) {
            System.out.println("Student count exceeds the limit of " + students.length);
            return;
        }
        students[studentCount++] = student;
    }

    public void addProfessor(Professor professor) {
        if (professorCount >= professors.length) {
            System.out.println("Professor count exceeds the limit of " + professors.length);
            return;
        }
        professors[professorCount++] = professor;
    }

    public void addCourse(Course course) {
        if (courseCount >= courses.length) {
            System.out.println("Course count exceeds the limit of " + courses.length);
            return;
        }
        courses[courseCount++] = course;
    }

    public void searchById(String id) {
        for (Student student : students) {
            if (student != null && student.getId().equals(id)) {
                System.out.println(student);
                return;
            }
        }
        for (Professor professor : professors) {
            if (professor != null && professor.getId().equals(id)) {
                System.out.println(professor);
                return;
            }
        }
        System.out.println("Person not found.");
    }

    public void searchByCourseCode(String courseCode) {
        for (Student student : students) {
            if (student != null) {
                for (Course course : student.getCourses()) {
                    if (course != null && course.getCourseCode() == Integer.parseInt(courseCode)) {
                        System.out.println(student);
                        break;
                    }
                }
            }
        }
    }


    public void displayAllPeople(){
        for (Student student : students) {
            if (student != null) {
                System.out.println(student);
            }
        }
        for (Professor professor : professors) {
            if (professor != null) {
                System.out.println(professor);
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
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

    public Professor[] getProfessors() {
        return professors;
    }

    public void setProfessors(Professor[] professors) {
        this.professors = professors;
    }

    public int getProfessorCount() {
        return professorCount;
    }

    public void setProfessorCount(int professorCount) {
        this.professorCount = professorCount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        University that = (University) o;
        return studentCount == that.studentCount && professorCount == that.professorCount && courseCount == that.courseCount && Objects.equals(name, that.name) && Objects.deepEquals(students, that.students) && Objects.deepEquals(professors, that.professors) && Objects.deepEquals(courses, that.courses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, Arrays.hashCode(students), Arrays.hashCode(professors), Arrays.hashCode(courses), studentCount, professorCount, courseCount);
    }

    @Override
    public String toString() {
        return "University{" +
                "name='" + name + '\'' +
                ", students=" + Arrays.toString(students) +
                ", professors=" + Arrays.toString(professors) +
                ", courses=" + Arrays.toString(courses) +
                ", studentCount=" + studentCount +
                ", professorCount=" + professorCount +
                ", courseCount=" + courseCount +
                '}';
    }
}