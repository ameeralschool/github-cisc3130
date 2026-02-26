package HW2;

public class Enrollment {
    private String enrollmentId;
    private String studentId;
    private String courseCode;
    private String grade;
    private String semester;

    public Enrollment(String enrollmentId, String studentId, String courseCode, String grade, String semester) {
        this.enrollmentId = enrollmentId;
        this.studentId = studentId;
        this.courseCode = courseCode;
        this.grade = grade;
        this.semester = semester;
    }

    public String getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(String enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "enrollmentId='" + enrollmentId + '\'' +
                ", studentId='" + studentId + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", grade='" + grade + '\'' +
                ", semester='" + semester + '\'' +
                '}';
    }

    public double getGradePoints() {
        if (grade == null) return 0.0;
        if (grade.equals("A")) return 4.0;
        else if (grade.equals("B")) return 3.0;
        else if (grade.equals("C")) return 2.0;
        else if (grade.equals("D")) return 1.0;
        else return 0.0;
    }

    public boolean isPassing() {
        if (grade == null) return false;
        if (grade.equals("A")) return true;
        else if (grade.equals("B")) return true;
        else if (grade.equals("C")) return true;
        else if (grade.equals("D")) return true;
        else return false;
    }


}
