package HW2;

import java.util.ArrayList;

public class EnrollmentManager {

    private ArrayList<Enrollment> enrollments;

    public EnrollmentManager() {
        this.enrollments = new ArrayList<>();
    }
    private int enrollmentCounter = 0;
    public void enrollStudent(String studentId, String courseCode, String semester) {
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudentId().equals(studentId) &&
                    enrollment.getCourseCode().equals(courseCode) &&
                    enrollment.getSemester().equals(semester)) {
                System.out.println("Student is already enrolled in this course.");
                return;
            }
        }
        enrollmentCounter++;
        String enrollmentId = String.format("E%03d", enrollmentCounter);
        enrollments.add(new Enrollment(enrollmentId, studentId, courseCode, null, semester));
    }

    public Enrollment findEnrollment(String enrollmentId) {
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getEnrollmentId().equals(enrollmentId)) return enrollment;
        }
        return null;
    }

    public boolean dropEnrollment(String enrollmentId) {
        Enrollment enrollment = findEnrollment(enrollmentId);
        if (enrollment == null) {
            return false;
        } else {
            enrollments.remove(enrollment);
            return true;
        }
    }

    public ArrayList<Enrollment> getEnrollmentsByStudent(String studentId) {
        ArrayList<Enrollment> studentEnrollment = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudentId().equals(studentId)) {
                studentEnrollment.add(enrollment);
            }
        }
        return studentEnrollment;
    }

    public ArrayList<Enrollment> getEnrollmentsByCourse(String courseCode) {
        ArrayList<Enrollment> courseEnrollment = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getCourseCode().equals(courseCode)) {
                courseEnrollment.add(enrollment);
            }
        }
        return courseEnrollment;
    }

    public void assignGrade(String enrollmentId, String grade) {
        Enrollment enrollment = findEnrollment(enrollmentId);
        if (enrollment == null) return;
        if (!grade.equals("A") && !grade.equals("B") && !grade.equals("C")
                && !grade.equals("D") && !grade.equals("F")) {
            System.out.println("Invalid grade.");
            return;
        }
        enrollment.setGrade(grade);
    }

    public double calculateStudentGpa(String studentId) {
        ArrayList<Enrollment> studentEnrollments = getEnrollmentsByStudent(studentId);
        if (studentEnrollments.isEmpty()) return 0.0;

        double total = 0.0;
        int count = 0;
        for (Enrollment enrollment : studentEnrollments) {
            if (enrollment.getGrade() != null) {
                total += enrollment.getGradePoints();
                count++;
            }
        }
        if (count == 0) return 0.0;
        return total / count;
    }

    public ArrayList<String> getStudentsInCourse(String courseCode) {
        ArrayList<String> studentIds = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getCourseCode().equals(courseCode)) {
                studentIds.add(enrollment.getStudentId());
            }
        }
        return studentIds;
    }

    public int getEnrollmentCount(String courseCode) {
        return getStudentsInCourse(courseCode).size();
    }

    public void printAllEnrollments() {
        if (enrollments.isEmpty()) {
            System.out.println("No enrollments found.");
            return;
        }
        for (Enrollment enrollment : enrollments) {
            String gradePrint;
            if (enrollment.getGrade() == null) gradePrint = "Not graded";
            else gradePrint = enrollment.getGrade();

            System.out.println("ID: " + enrollment.getEnrollmentId() +
                    " | Student: " + enrollment.getStudentId() +
                    " | Course: " + enrollment.getCourseCode() +
                    " | Grade: " + gradePrint +
                    " | Semester: " + enrollment.getSemester());
        }
    }
}


