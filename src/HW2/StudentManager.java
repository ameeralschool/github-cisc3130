package HW2;

import java.util.ArrayList;

public class StudentManager {
    private ArrayList<Student> students;

    public StudentManager() {
        this.students = new ArrayList<>();
    }

    public Student findStudent(String studentID) {
        for (Student student : students) {
            if (student.getStudentID().equals(studentID)) {
                return student;
            }
        }
        return null;
    }

    public void addStudent(Student student) {
        if (findStudent(student.getStudentID()) != null) {
            System.out.println("Student with ID " + student.getStudentID() + " already exists.");
            return;
        }
        students.add(student);
    }

    public boolean removeStudent(String studentID) {
        Student student = findStudent(studentID);
        if (student == null) {
            return false;
        } else {
            students.remove(student);
            return true;
        }
    }

    public ArrayList<Student> getStudentsByMajor(String major) {

        ArrayList<Student> studentsinmajor = new ArrayList<>();
        for (Student student : students) {
            if (student.getMajor().equals(major)) {
                studentsinmajor.add(student);
            }
        }
        return studentsinmajor;
    }

    public ArrayList<Student> getStudentsByYear(int year) {
        ArrayList<Student> studentsinyear = new ArrayList<>();
        for (Student student : students) {
            if (student.getYear() == year) {
                studentsinyear.add(student);
            }
        }
        return studentsinyear;
    }

    public ArrayList<Student> getHonorStudents(double minGPA) {
        ArrayList<Student> honorstudents = new ArrayList<>();
        for (Student student : students) {
            if (student.getGpa() >= minGPA) {
                honorstudents.add(student);
            }
        }
        return honorstudents;
    }

    public double getAverageGpa() {
        if (students.isEmpty()) {
            return 0.0;
        }
        double allgpa = 0;


        for (Student student : students) {
            allgpa += student.getGpa();

        }
        return allgpa / students.size();
    }

    public double getAverageGpaByMajor(String major) {
        ArrayList<Student> studentsinMajor = getStudentsByMajor(major);
        if (studentsinMajor.isEmpty()) {
            return 0.0;
        }
        double allGpa = 0;
        for (Student student : studentsinMajor) {
            allGpa += student.getGpa();
        }
        return allGpa / studentsinMajor.size();
    }

    public void printAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students enrolled.");
            return;
        }
        for (Student student : students) {
            String yearLabel;
            if (student.getYear() == 1) yearLabel = "Freshman";
            else if (student.getYear() == 2) yearLabel = "Sophomore";
            else if (student.getYear() == 3) yearLabel = "Junior";
            else yearLabel = "Senior";
            System.out.println("ID: " + student.getStudentID() +
                    " | Name: " + student.getFullName() +
                    " | Major: " + student.getMajor() +
                    " | GPA: " + student.getGpa() +
                    " | Year: " + yearLabel);
        }
    }

    public int getTotalStudents() {
        return students.size();
    }

    public ArrayList<String> getAllMajors() {
        ArrayList<String> majors = new ArrayList<>();
        for (Student student : students) {
            if (majors.contains(student.getMajor())) {
            } else {
                majors.add(student.getMajor());
            }
        }
        return majors;
    }

}















