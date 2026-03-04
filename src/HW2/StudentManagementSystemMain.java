package HW2;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystemMain {

    private static StudentManager studentManager = new StudentManager();
    private static CourseManager courseManager = new CourseManager();
    private static EnrollmentManager enrollmentManager = new EnrollmentManager();
    private static ReportGenerator reportGenerator = new ReportGenerator();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        loadSampleData();
        demonstrateGenerics();

        boolean running = true;
        while (running) {
            printMenu();
            System.out.print("Enter choice: ");
            String choice = scanner.nextLine().trim();

            if (choice.equals("1")) addStudent();
            else if (choice.equals("2")) removeStudent();
            else if (choice.equals("3")) findStudent();
            else if (choice.equals("4")) studentManager.printAllStudents();
            else if (choice.equals("5")) addCourse();
            else if (choice.equals("6")) enrollStudent();
            else if (choice.equals("7")) assignGrade();
            else if (choice.equals("8")) calculateGpa();
            else if (choice.equals("9")) generateReports();
            else if (choice.equals("10")) {
                running = false;
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("Student Management System");
        System.out.println("1. Add Student");
        System.out.println("2. Remove Student");
        System.out.println("3. Find Student");
        System.out.println("4. List All Students");
        System.out.println("5. Add Course");
        System.out.println("6. Enroll Student in Course");
        System.out.println("7. Assign Grade");
        System.out.println("8. Calculate Student GPA");
        System.out.println("9. Generate Reports");
        System.out.println("10. Exit");
    }

    private static void addStudent() {
        System.out.print("Student ID: ");
        String id = scanner.nextLine().trim();
        System.out.print("First Name: ");
        String first = scanner.nextLine().trim();
        System.out.print("Last Name: ");
        String last = scanner.nextLine().trim();
        System.out.print("Email: ");
        String email = scanner.nextLine().trim();
        System.out.print("GPA: ");
        double gpa = Double.parseDouble(scanner.nextLine().trim());
        System.out.print("Major: ");
        String major = scanner.nextLine().trim();
        System.out.print("Year (1-4): ");
        int year = Integer.parseInt(scanner.nextLine().trim());

        studentManager.addStudent(new Student(id, first, last, email, gpa, major, year));
        System.out.println("Student added.");
    }

    private static void removeStudent() {
        System.out.print("Enter Student ID to remove: ");
        String id = scanner.nextLine().trim();
        boolean removed = studentManager.removeStudent(id);
        if (removed) System.out.println("Student removed.");
        else System.out.println("Student not found.");
    }

    private static void findStudent() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine().trim();
        Student student = studentManager.findStudent(id);
        if (student == null) System.out.println("Student not found.");
        else System.out.println(student);
    }

    private static void addCourse() {
        System.out.print("Course Code: ");
        String code = scanner.nextLine().trim();
        System.out.print("Course Name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Credits: ");
        int credits = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("Instructor: ");
        String instructor = scanner.nextLine().trim();
        System.out.print("Max Enrollment: ");
        int maxEnroll = Integer.parseInt(scanner.nextLine().trim());

        courseManager.addCourse(new Course(code, name, credits, instructor, maxEnroll));
        System.out.println("Course added.");
    }

    private static void enrollStudent() {
        System.out.print("Student ID: ");
        String studentId = scanner.nextLine().trim();
        System.out.print("Course Code: ");
        String courseCode = scanner.nextLine().trim();
        System.out.print("Semester: ");
        String semester = scanner.nextLine().trim();
        enrollmentManager.enrollStudent(studentId, courseCode, semester);
        System.out.println("Enrollment processed.");
    }

    private static void assignGrade() {
        System.out.print("Enrollment ID: ");
        String enrollmentId = scanner.nextLine().trim();
        System.out.print("Grade (A/B/C/D/F): ");
        String grade = scanner.nextLine().trim();
        enrollmentManager.assignGrade(enrollmentId, grade);
        System.out.println("Grade assigned.");
    }

    private static void calculateGpa() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine().trim();
        double gpa = enrollmentManager.calculateStudentGpa(id);
        System.out.println("Calculated GPA: " + String.format("%.2f", gpa));
    }

    private static void generateReports() {
        System.out.println("1. Student Report");
        System.out.println("2. Course Report");
        System.out.println("3. Major Report");
        System.out.println("4. Honor Roll Report");
        System.out.print("Choose report type: ");
        String choice = scanner.nextLine().trim();

        if (choice.equals("1")) {
            System.out.print("Student ID: ");
            String id = scanner.nextLine().trim();
            reportGenerator.generateStudentReport(id, studentManager, enrollmentManager);
        } else if (choice.equals("2")) {
            System.out.print("Course Code: ");
            String code = scanner.nextLine().trim();
            reportGenerator.generateCourseReport(code, courseManager, enrollmentManager);
        } else if (choice.equals("3")) {
            System.out.print("Major: ");
            String major = scanner.nextLine().trim();
            reportGenerator.generateMajorReport(major, studentManager);
        } else if (choice.equals("4")) {
            System.out.print("Minimum GPA: ");
            double minGpa = Double.parseDouble(scanner.nextLine().trim());
            reportGenerator.generateHonorRollReport(studentManager, minGpa);
        } else {
            System.out.println("Invalid choice.");
        }
    }

    private static void loadSampleData() {
        studentManager.addStudent(new Student("S001", "Alice", "Smith", "alice@university.edu", 3.8, "Computer Science", 2));
        studentManager.addStudent(new Student("S002", "Bob", "Jones", "bob@university.edu", 3.5, "Mathematics", 3));
        studentManager.addStudent(new Student("S003", "Charlie", "Brown", "charlie@university.edu", 3.9, "Computer Science", 2));
        studentManager.addStudent(new Student("S004", "Diana", "Prince", "diana@university.edu", 3.2, "Physics", 1));
        studentManager.addStudent(new Student("S005", "Eve", "Adams", "eve@university.edu", 3.6, "Computer Science", 4));
        studentManager.addStudent(new Student("S006", "Frank", "Miller", "frank@university.edu", 2.9, "Mathematics", 2));
        studentManager.addStudent(new Student("S007", "Grace", "Lee", "grace@university.edu", 3.7, "Biology", 3));
        studentManager.addStudent(new Student("S008", "Henry", "Kim", "henry@university.edu", 3.1, "Physics", 1));
        studentManager.addStudent(new Student("S009", "Ivy", "Chen", "ivy@university.edu", 3.95, "Computer Science", 3));
        studentManager.addStudent(new Student("S010", "Jack", "Wu", "jack@university.edu", 2.8, "Biology", 2));

        ArrayList<String> dsPrereqs = new ArrayList<>();
        dsPrereqs.add("CISC1115");
        courseManager.addCourse(new Course("CISC3130", "Data Structures", 3, "Dr. Smith", 30, dsPrereqs));
        courseManager.addCourse(new Course("MATH101", "Calculus I", 4, "Dr. Johnson", 25));
        courseManager.addCourse(new Course("CISC1115", "Intro to Programming", 3, "Dr. Smith", 35));
        courseManager.addCourse(new Course("PHYS201", "Physics I", 4, "Dr. Newton", 20));
        courseManager.addCourse(new Course("BIO101", "Intro to Biology", 3, "Dr. Darwin", 30));

        enrollmentManager.enrollStudent("S001", "CISC1115", "Fall 2023");
        enrollmentManager.assignGrade("E001", "A");
        enrollmentManager.enrollStudent("S001", "CISC3130", "Spring 2024");
        enrollmentManager.assignGrade("E002", "A");
        enrollmentManager.enrollStudent("S001", "MATH101", "Fall 2024");
        enrollmentManager.assignGrade("E003", "B");

        enrollmentManager.enrollStudent("S002", "MATH101", "Fall 2023");
        enrollmentManager.assignGrade("E004", "A");
        enrollmentManager.enrollStudent("S002", "PHYS201", "Spring 2024");
        enrollmentManager.assignGrade("E005", "B");

        enrollmentManager.enrollStudent("S003", "CISC1115", "Fall 2023");
        enrollmentManager.assignGrade("E006", "A");
        enrollmentManager.enrollStudent("S003", "BIO101", "Spring 2024");
        enrollmentManager.assignGrade("E007", "B");

        enrollmentManager.enrollStudent("S004", "PHYS201", "Fall 2024");
        enrollmentManager.enrollStudent("S005", "CISC1115", "Fall 2022");
        enrollmentManager.assignGrade("E009", "B");
        enrollmentManager.enrollStudent("S005", "CISC3130", "Spring 2023");
        enrollmentManager.assignGrade("E010", "A");

        System.out.println("Sample data loaded: " + studentManager.getTotalStudents() + " students, "
                + courseManager.getTotalCourses() + " courses.");

        studentManager.printAllStudents();
        System.out.println();
        courseManager.printAllCourses();
        System.out.println();
        enrollmentManager.printAllEnrollments();
        System.out.println();

        System.out.println("Average GPA: " + String.format("%.2f", studentManager.getAverageGpa()));
        System.out.println("CS Students: " + studentManager.getStudentsByMajor("Computer Science").size());
        System.out.println("S001 GPA from enrollments: " + String.format("%.2f", enrollmentManager.calculateStudentGpa("S001")));
        System.out.println("All Majors: " + studentManager.getAllMajors());
        System.out.println();

        reportGenerator.generateStudentReport("S001", studentManager, enrollmentManager);
        System.out.println();
        reportGenerator.generateCourseReport("CISC3130", courseManager, enrollmentManager);
        System.out.println();
        reportGenerator.generateHonorRollReport(studentManager, 3.5);
        System.out.println();
    }

    private static void demonstrateGenerics() {
        System.out.println("GENERICS DEMONSTRATION");

        GenericList<String> strings = new GenericList<>();
        strings.add("Hello");
        strings.add("World");
        strings.add("Java");
        System.out.println("String list: " + strings);
        System.out.println("Size: " + strings.size());
        System.out.println("Contains Java: " + strings.contains("Java"));

        GenericList<Integer> numbers = new GenericList<>();
        numbers.add(42);
        numbers.add(17);
        numbers.add(99);
        numbers.add(5);
        System.out.println("Before sort: " + numbers);
        numbers.sort();
        System.out.println("After sort: " + numbers);
        System.out.println("Max: " + numbers.findMax());

        GenericList<Student> studentList = new GenericList<>();
        studentList.add(new Student("T001", "Test", "One", "t1@test.com", 3.5, "CS", 1));
        studentList.add(new Student("T002", "Test", "Two", "t2@test.com", 3.9, "CS", 2));
        studentList.add(new Student("T003", "Test", "Three", "t3@test.com", 3.1, "CS", 3));
        System.out.println("Student list size: " + studentList.size());
        Student maxStudent = studentList.findMax();
        if (maxStudent != null) {
            System.out.println("Highest GPA student: " + maxStudent.getFullName() + " - GPA: " + maxStudent.getGpa());
        }

        GenericStack<String> stack = new GenericStack<>();
        stack.push("First");
        stack.push("Second");
        stack.push("Third");
        System.out.println("Stack: " + stack);
        System.out.println("Pop: " + stack.pop());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Stack after pop: " + stack);

        GenericQueue<Integer> queue = new GenericQueue<>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println("Queue: " + queue);
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Peek: " + queue.peek());
        System.out.println("Queue after dequeue: " + queue);

        Pair<String, Double> gradeEntry1 = new Pair<>("CISC3130", 4.0);
        Pair<String, Double> gradeEntry2 = new Pair<>("MATH101", 3.0);
        System.out.println("Grade pair 1: " + gradeEntry1);
        System.out.println("Grade pair 2: " + gradeEntry2);

        ArrayList<Pair<String, Double>> gradeList = new ArrayList<>();
        gradeList.add(gradeEntry1);
        gradeList.add(gradeEntry2);
        gradeList.add(new Pair<>("BIO101", 3.0));
        System.out.println("All grade pairs: " + gradeList);

        ArrayList<String> words = new ArrayList<>();
        words.add("Alpha");
        words.add("Beta");
        words.add("Gamma");
        System.out.println("Before swap: " + words);
        ArrayListUtils.swap(words, 0, 2);
        System.out.println("After swap: " + words);
        System.out.println("Max string: " + ArrayListUtils.findMax(words));

        ArrayListUtils.reverse(words);
        System.out.println("After reverse: " + words);

        ArrayList<String> moreWords = new ArrayList<>();
        moreWords.add("Delta");
        moreWords.add("Epsilon");
        ArrayList<String> merged = ArrayListUtils.merge(words, moreWords);
        System.out.println("Merged: " + merged);

        ArrayList<Student> allStudents = studentList.getAll();
        ArrayList<Student> highGpa = ArrayListUtils.filter(allStudents, new GenericPredicate<Student>() {
            @Override
            public boolean test(Student s) {
                return s.getGpa() >= 3.5;
            }
        });
        System.out.println("Students with GPA >= 3.5: " + highGpa.size());

        ArrayList<Integer> ints = new ArrayList<>();
        ints.add(10);
        ints.add(20);
        ints.add(30);
        System.out.println("Sum: " + ArrayListUtils.sum(ints));
        System.out.println("Average: " + ArrayListUtils.average(ints));

        ArrayList<Integer> aboveFifteen = ArrayListUtils.filterAbove(ints, 15);
        System.out.println("Numbers above 15: " + aboveFifteen);

        ArrayList<Double> doubles = new ArrayList<>();
        doubles.add(1.5);
        doubles.add(2.5);
        doubles.add(3.5);
        System.out.println("Sum of doubles: " + ArrayListUtils.sum(doubles));
        System.out.println("Average of doubles: " + ArrayListUtils.average(doubles));

        System.out.println("sumNumbers(ints): " + ArrayListUtils.sumNumbers(ints));
        System.out.println("sumNumbers(doubles): " + ArrayListUtils.sumNumbers(doubles));

        ArrayList<Number> numberList = new ArrayList<>();
        ArrayListUtils.addNumbers(numberList);
        System.out.println("After addNumbers: " + numberList);

        System.out.println("printList with words:");
        ArrayListUtils.printList(words);

        System.out.println();
    }

}