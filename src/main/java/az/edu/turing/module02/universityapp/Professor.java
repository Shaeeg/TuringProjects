package az.edu.turing.module02.universityapp;

import java.util.Arrays;
import java.util.Objects;

public class Professor extends Person {
    private String department;
    private String[] subjects;
    int subjectsCount = 0;

    Professor(String fullName, int age, String id, String department, int subjectCount) {
        super(fullName, age, id);
        this.department = department;
        this.subjects = new String[subjectCount];
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String[] getSubjects() {
        return subjects;
    }

    public void setSubjects(String[] subjects) {
        this.subjects = subjects;
    }

    public int getSubjectsCount() {
        return subjectsCount;
    }

    public void setSubjectsCount(int subjectsCount) {
        this.subjectsCount = subjectsCount;
    }

    public void addSubject(String subject) {
        if(subjectsCount >= subjects.length) {
            System.out.println("Subject count exceeded");
            return;
        }
        this.subjects[subjectsCount++] = subject;
    }

    public String getSubjectList() {
        return Arrays.toString(Arrays.copyOf(subjects, subjectsCount));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Professor professor = (Professor) o;
        return Objects.equals(department, professor.department) && Objects.deepEquals(subjects, professor.subjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), department, Arrays.hashCode(subjects));
    }

    @Override
    public String toString() {
        return super.toString() + ", department: " + department + ", subjects: " + Arrays.toString(subjects);
    }
}
