package az.edu.turing.module02.universityapp;

public class UniversityApp {
    public static void main(String[] args) {
        // Create a university
        University university = new University("Turing", 5, 5, 5);

        // Create some professors
        Professor professor1 = new Professor("Dr. John Smith", 45, "P001", "Computer Science", 3);
        professor1.addSubject("Java Programming");
        professor1.addSubject("Data Structures");
        professor1.addSubject("Algorithms");

        Professor professor2 = new Professor("Dr. Emily Davis", 40, "P002", "Mathematics", 2);
        professor2.addSubject("Calculus");
        professor2.addSubject("Linear Algebra");

        // Create courses
        Course course1 = new Course(101, "Java Programming", professor1, 3, university);
        Course course2 = new Course(102, "Data Structures", professor1, 3, university);
        Course course3 = new Course(201, "Calculus", professor2, 2, university);

        // Create students
        Student student1 = new Student("Alice Johnson", 20, "S001", "Computer Science", 2, university);
        Student student2 = new Student("Bob Lee", 21, "S002", "Mathematics", 2, university);
        Student student3 = new Student("Charlie Brown", 22, "S003", "Computer Science", 2, university);

        // Enroll students in courses
        student1.enrollInCourse(course1);  // Alice enrolls in Java Programming
        student1.enrollInCourse(course2);  // Alice enrolls in Data Structures

        student2.enrollInCourse(course3);  // Bob enrolls in Calculus

        student3.enrollInCourse(course1);  // Charlie enrolls in Java Programming
        student3.enrollInCourse(course2);  // Charlie enrolls in Data Structures

        // Update grades for students
        student1.updateGrades(course1, 4.0);  // Alice gets 4.0 in Java Programming
        student1.updateGrades(course2, 3.5);  // Alice gets 3.5 in Data Structures

        student2.updateGrades(course3, 3.7);  // Bob gets 3.7 in Calculus

        student3.updateGrades(course1, 3.8);  // Charlie gets 3.8 in Java Programming
        student3.updateGrades(course2, 4.0);  // Charlie gets 4.0 in Data Structures

        // Print out the information for courses and students
        System.out.println("Courses:");
        System.out.println(course1);
        System.out.println(course2);
        System.out.println(course3);

        System.out.println("\nStudents:");
        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);

        // Print GPA of students
        System.out.println("\nStudent GPAs:");
        System.out.println(student1.getFullName() + "'s GPA: " + student1.calculateGpa());
        System.out.println(student2.getFullName() + "'s GPA: " + student2.calculateGpa());
        System.out.println(student3.getFullName() + "'s GPA: " + student3.calculateGpa());

        // Print course GPA
        System.out.println("\nCourse GPA:");
        System.out.println("Java Programming GPA: " + course1.calculateCourseGpa());
        System.out.println("Data Structures GPA: " + course2.calculateCourseGpa());
        System.out.println("Calculus GPA: " + course3.calculateCourseGpa());
    }
}
