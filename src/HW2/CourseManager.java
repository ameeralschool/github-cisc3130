package HW2;


import java.util.ArrayList;

public class CourseManager {

    private ArrayList<Course> courses;

    public CourseManager() {
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public Course findCourse(String courseCode) {
        for (Course course : courses) {
            if (course.getCourseCode().equals(courseCode)) {
                return course;
            }
        }
        return null;
    }

    public ArrayList<Course> getCoursesByInstructor(String instructor) {
        ArrayList<Course> instructorCourses = new ArrayList<>();
        for (Course course : courses) {
            if (course.getInstructor().equals(instructor)) {
                instructorCourses.add(course);
            }
        }
        return instructorCourses;
    }

    public ArrayList<Course> getAvailableCourses(String studentId, StudentManager studentManager, EnrollmentManager enrollmentManager) {
        ArrayList<Course> availableCourses = new ArrayList<>();
        ArrayList<Enrollment> studentEnrollments = enrollmentManager.getEnrollmentsByStudent(studentId);

        for (Course course : courses) {
            boolean alreadyEnrolled = false;
            for (Enrollment enrollment : studentEnrollments) {
                if (enrollment.getCourseCode().equals(course.getCourseCode())) {
                    alreadyEnrolled = true;
                }
            }

            boolean prereqsMet = true;
            for (String prereq : course.getPrerequisites()) {
                boolean hasPrereq = false;
                for (Enrollment enrollment : studentEnrollments) {
                    if (enrollment.getCourseCode().equals(prereq) && enrollment.isPassing()) {
                        hasPrereq = true;
                    }
                }
                if (hasPrereq == false) {
                    prereqsMet = false;
                }
            }

            if (alreadyEnrolled == false && prereqsMet == true) {
                availableCourses.add(course);
            }
        }
        return availableCourses;
    }

    public void printAllCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses found.");
            return;
        }
        for (Course course : courses) {
            System.out.println("Code: " + course.getCourseCode() +
                    " | Name: " + course.getCourseName() +
                    " | Credits: " + course.getCredits() +
                    " | Instructor: " + course.getInstructor() +
                    " | Max Enrollment: " + course.getMaxEnrollment());
        }
    }

    public int getTotalCourses() {
        return courses.size();
    }
}

