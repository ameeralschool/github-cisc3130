package HW2;

import java.util.ArrayList;

public class ReportGenerator {

    public void generateStudentReport(String studentId, StudentManager sm, EnrollmentManager em) {
        Student student = sm.findStudent(studentId);
        if (student == null) {
            System.out.println("Student not found: " + studentId);
            return;
        }

        System.out.println("STUDENT REPORT");
        System.out.println("ID: " + student.getStudentID());
        System.out.println("Name: " + student.getFullName());
        System.out.println("Major: " + student.getMajor());
        System.out.println("Year: " + student.getYear());
        System.out.println("Email: " + student.getEmail());

        ArrayList<Enrollment> enrollments = em.getEnrollmentsByStudent(studentId);
        if (enrollments.isEmpty()) {
            System.out.println("No enrollments found.");
        } else {
            System.out.println("Enrolled Courses:");
            for (Enrollment enrollment : enrollments) {
                String gradePrint;
                if (enrollment.getGrade() == null) gradePrint = "Not graded";
                else gradePrint = enrollment.getGrade();
                System.out.println("  " + enrollment.getCourseCode() +
                        " | Grade: " + gradePrint +
                        " | Semester: " + enrollment.getSemester());
            }
        }

        double gpa = em.calculateStudentGpa(studentId);
        System.out.println("Calculated GPA: " + String.format("%.2f", gpa));
    }

    public void generateCourseReport(String courseCode, CourseManager cm, EnrollmentManager em) {
        Course course = cm.findCourse(courseCode);
        if (course == null) {
            System.out.println("Course not found: " + courseCode);
            return;
        }

        System.out.println("COURSE REPORT");
        System.out.println("Code: " + course.getCourseCode());
        System.out.println("Name: " + course.getCourseName());
        System.out.println("Credits: " + course.getCredits());
        System.out.println("Instructor: " + course.getInstructor());
        System.out.println("Max Enrollment: " + course.getMaxEnrollment());

        ArrayList<Enrollment> enrollments = em.getEnrollmentsByCourse(courseCode);
        if (enrollments.isEmpty()) {
            System.out.println("No students enrolled.");
        } else {
            System.out.println("Enrolled Students:");
            double totalGrade = 0.0;
            int gradedCount = 0;
            for (Enrollment enrollment : enrollments) {
                String gradePrint;
                if (enrollment.getGrade() == null) gradePrint = "Not graded";
                else {
                    gradePrint = enrollment.getGrade();
                    totalGrade += enrollment.getGradePoints();
                    gradedCount++;
                }
                System.out.println("  Student: " + enrollment.getStudentId() +
                        " | Grade: " + gradePrint);
            }
            System.out.println("Total Enrolled: " + enrollments.size());
            if (gradedCount > 0) {
                System.out.println("Average Grade Points: " + String.format("%.2f", totalGrade / gradedCount));
            } else {
                System.out.println("No grades assigned yet.");
            }
        }
    }

    public void generateMajorReport(String major, StudentManager sm) {
        ArrayList<Student> studentsInMajor = sm.getStudentsByMajor(major);

        System.out.println("MAJOR REPORT: " + major);
        if (studentsInMajor.isEmpty()) {
            System.out.println("No students found in this major.");
        } else {
            for (Student student : studentsInMajor) {
                System.out.println("  " + student.getStudentID() +
                        " | " + student.getFullName() +
                        " | GPA: " + student.getGpa());
            }
            double avgGpa = sm.getAverageGpaByMajor(major);
            System.out.println("Average GPA for " + major + ": " + String.format("%.2f", avgGpa));
            System.out.println("Total Students: " + studentsInMajor.size());
        }
    }

    public void generateHonorRollReport(StudentManager sm, double minGpa) {
        ArrayList<Student> honorStudents = sm.getHonorStudents(minGpa);

        System.out.println("HONOR ROLL (GPA >= " + minGpa + ")");
        if (honorStudents.isEmpty()) {
            System.out.println("No students qualify for honor roll.");
        } else {
            for (Student student : honorStudents) {
                System.out.println("  " + student.getStudentID() +
                        " | " + student.getFullName() +
                        " | Major: " + student.getMajor() +
                        " | GPA: " + student.getGpa());
            }
            System.out.println("Total Honor Students: " + honorStudents.size());
        }
    }

}