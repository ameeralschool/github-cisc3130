package HW2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArrayListOperationsDemo {

    public static void main(String[] args) {

        System.out.println("Array to ArrayList");

        Student[] studentArray = new Student[3];
        studentArray[0] = new Student("S001", "Alice", "Smith", "alice@university.edu", 3.8, "Computer Science", 2);
        studentArray[1] = new Student("S002", "Bob", "Jones", "bob@university.edu", 3.5, "Mathematics", 3);
        studentArray[2] = new Student("S003", "Charlie", "Brown", "charlie@university.edu", 3.9, "Computer Science", 2);

        ArrayList<Student> studentList = new ArrayList<>(Arrays.asList(studentArray));

        System.out.println("Converted array of " + studentArray.length + " students to ArrayList.");
        System.out.println("ArrayList size: " + studentList.size());

        studentList.add(new Student("S004", "Diana", "Prince", "diana@university.edu", 3.7, "Physics", 1));
        System.out.println("After adding one more: " + studentList.size());

        studentList.remove(0);
        System.out.println("After removing first: " + studentList.size());


        System.out.println("ArrayList to Array ");

        ArrayList<Student> listForConversion = new ArrayList<>();
        listForConversion.add(new Student("S010", "Eve", "Adams", "eve@university.edu", 3.6, "Biology", 2));
        listForConversion.add(new Student("S011", "Frank", "Miller", "frank@university.edu", 3.2, "Chemistry", 3));


        Student[] convertedArray = listForConversion.toArray(new Student[0]);

        System.out.println("ArrayList version:");
        for (Student s : listForConversion) {
            System.out.println("  " + s.getFullName());
        }
        System.out.println("Array version:");
        for (Student s : convertedArray) {
            System.out.println("  " + s.getFullName());
        }



        System.out.println("SubList Operations");

        ArrayList<Student> bigList = new ArrayList<>();
        bigList.add(new Student("S020", "Grace", "Lee", "grace@university.edu", 3.1, "English", 1));
        bigList.add(new Student("S021", "Henry", "Kim", "henry@university.edu", 3.4, "English", 2));
        bigList.add(new Student("S022", "Ivy", "Chen", "ivy@university.edu", 3.7, "Math", 3));
        bigList.add(new Student("S023", "Jack", "Wu", "jack@university.edu", 3.9, "Math", 4));
        bigList.add(new Student("S024", "Kate", "Park", "kate@university.edu", 2.8, "History", 2));


        List<Student> sub = bigList.subList(1, 3);
        System.out.println("SubList (index 1 to 2):");
        for (Student s : sub) {
            System.out.println("  " + s.getFullName() + " - GPA: " + s.getGpa());
        }

        sub.get(0).setGpa(4.0);
        System.out.println("After changing subList element's GPA to 4.0:");
        System.out.println("  Original list index 1 GPA: " + bigList.get(1).getGpa());



        System.out.println("ArrayList Sorting");

        ArrayList<Student> sortList = new ArrayList<>();
        sortList.add(new Student("S030", "Zara", "Thomas", "zara@university.edu", 3.2, "CS", 2));
        sortList.add(new Student("S031", "Amy", "Wilson", "amy@university.edu", 3.9, "CS", 3));
        sortList.add(new Student("S032", "Mike", "Davis", "mike@university.edu", 3.5, "CS", 1));


        Collections.sort(sortList);
        System.out.println("Sorted by GPA (descending):");
        for (Student s : sortList) {
            System.out.println("  " + s.getFullName() + " - GPA: " + s.getGpa());
        }

        Comparator<Student> byLastName = new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getLastName().compareTo(s2.getLastName());
            }
        };

        Collections.sort(sortList, byLastName);
        System.out.println("Sorted by Last Name (alphabetical):");
        for (Student s : sortList) {
            System.out.println("  " + s.getFullName());
        }


        System.out.println("ArrayList Searching");


        Student target = new Student("S031", "", "", "", 0, "", 0);
        int index = sortList.indexOf(target);
        System.out.println("indexOf S031: " + index);
        if (index >= 0) {
            System.out.println("  Found: " + sortList.get(index).getFullName());
        }


        boolean exists = sortList.contains(target);
        System.out.println("contains S031: " + exists);


        Collections.sort(sortList);
        System.out.println("After sorting by natural order (GPA descending) for binarySearch:");
        for (Student s : sortList) {
            System.out.println("  " + s.getFullName() + " - GPA: " + s.getGpa());
        }

        Student searchTarget = new Student("S032", "Mike", "Davis", "mike@university.edu", 3.5, "CS", 1);
        int bsResult = Collections.binarySearch(sortList, searchTarget);
        System.out.println("binarySearch for GPA 3.5: index = " + bsResult);

    }

}