package HW2;


import java.util.ArrayList;

public class ArrayListVsArrayDemo {

    public static void main(String[] args) {

        System.out.println("ArrayList vs Array Comparison");

        System.out.println("Creating array and ArrayList");

        Student[] studentArray = new Student[5];
        ArrayList<Student> studentArrayList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            String id = "S" + String.format("%03d", i);
            Student s = new Student(id, "First" + i, "Last" + i, id + "@school.edu", 3.0 + (i * 0.1), "CS", 1);
            studentArray[i] = s;
            studentArrayList.add(s);
        }
        System.out.println("Array size: " + studentArray.length);
        System.out.println("ArrayList size: " + studentArrayList.size());


        System.out.println("Adding elements (array limitation)");

        studentArrayList.add(new Student("S005", "Extra", "Student", "extra@school.edu", 3.5, "Math", 2));
        System.out.println("ArrayList after adding 6th element: size = " + studentArrayList.size());
        System.out.println("Array is stuck at size " + studentArray.length + " - need to create a new bigger array");

        Student[] biggerArray = new Student[studentArray.length + 1];
        for (int i = 0; i < studentArray.length; i++) {
            biggerArray[i] = studentArray[i];
        }
        biggerArray[5] = new Student("S005", "Extra", "Student", "extra@school.edu", 3.5, "Math", 2);
        studentArray = biggerArray;
        System.out.println("Array after manual resize: size = " + studentArray.length);


        System.out.println("Removing elements (array limitation)");

        studentArrayList.remove(2);
        System.out.println("ArrayList after removing index 2: size = " + studentArrayList.size());

        Student[] smallerArray = new Student[studentArray.length - 1];
        int j = 0;
        for (int i = 0; i < studentArray.length; i++) {
            if (i != 2) {
                smallerArray[j] = studentArray[i];
                j++;
            }
        }
        studentArray = smallerArray;
        System.out.println("Array after manual remove at index 2: size = " + studentArray.length);


        System.out.println("Performance Comparison");

        ArrayList<Student> perfArrayList = new ArrayList<>();
        long startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            String id = "P" + String.format("%05d", i);
            perfArrayList.add(new Student(id, "F" + i, "L" + i, id + "@test.edu", 3.0, "CS", 1));
        }
        long endTime = System.nanoTime();
        long arrayListAddTime = (endTime - startTime) / 1000000;
        System.out.println("ArrayList: Time to add 10,000 students: " + arrayListAddTime + " ms");

        Student[] perfArray = new Student[1];
        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            if (i >= perfArray.length) {
                Student[] newArray = new Student[perfArray.length * 2];
                for (int k = 0; k < perfArray.length; k++) {
                    newArray[k] = perfArray[k];
                }
                perfArray = newArray;
            }
            String id = "P" + String.format("%05d", i);
            perfArray[i] = new Student(id, "F" + i, "L" + i, id + "@test.edu", 3.0, "CS", 1);
        }
        endTime = System.nanoTime();
        long arrayAddTime = (endTime - startTime) / 1000000;
        System.out.println("Array: Time to add 10,000 students: " + arrayAddTime + " ms");


        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            int randomIndex = (int) (Math.random() * 10000);
            Student s = perfArrayList.get(randomIndex);
        }
        endTime = System.nanoTime();
        long arrayListAccessTime = (endTime - startTime) / 1000000;
        System.out.println("ArrayList: Time to access 1,000 random students: " + arrayListAccessTime + " ms");

        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            int randomIndex = (int) (Math.random() * 10000);
            Student s = perfArray[randomIndex];
        }
        endTime = System.nanoTime();
        long arrayAccessTime = (endTime - startTime) / 1000000;
        System.out.println("Array: Time to access 1,000 random students: " + arrayAccessTime + " ms");


        System.out.println("COMPARISON REPORT");
        System.out.println("Arrays are fixed size, ArrayLists grow dynamically");
        System.out.println("Arrays need manual resizing and shifting, ArrayLists handle it");
        System.out.println("Both have fast index access");
        System.out.println("Arrays can hold primitives, ArrayLists need wrapper objects");
        System.out.println("Use arrays when size is known and fixed");
        System.out.println("Use ArrayLists when size changes or you need built in methods");

    }

}
