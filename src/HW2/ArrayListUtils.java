package HW2;

import java.util.ArrayList;

public class ArrayListUtils {

    public static <T> void swap(ArrayList<T> list, int index1, int index2) {
        if (index1 < 0 || index1 >= list.size() || index2 < 0 || index2 >= list.size()) {
            System.out.println("Invalid index for swap.");
            return;
        }
        T temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }

    public static <T extends Comparable<T>> T findMax(ArrayList<T> list) {
        if (list.isEmpty()) return null;
        T max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).compareTo(max) > 0) {
                max = list.get(i);
            }
        }
        return max;
    }

    public static <T> ArrayList<T> filter(ArrayList<T> list, GenericPredicate<T> condition) {
        ArrayList<T> result = new ArrayList<>();
        for (T item : list) {
            if (condition.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

    public static <T> void reverse(ArrayList<T> list) {
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            T temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }

    public static <T> ArrayList<T> merge(ArrayList<T> list1, ArrayList<T> list2) {
        ArrayList<T> merged = new ArrayList<>();
        for (T item : list1) {
            merged.add(item);
        }
        for (T item : list2) {
            merged.add(item);
        }
        return merged;
    }

    public static <T extends Number> double sum(ArrayList<T> numbers) {
        double total = 0.0;
        for (T num : numbers) {
            total += num.doubleValue();
        }
        return total;
    }

    public static <T extends Number> double average(ArrayList<T> numbers) {
        if (numbers.isEmpty()) return 0.0;
        return sum(numbers) / numbers.size();
    }

    public static <T extends Number & Comparable<T>> ArrayList<T> filterAbove(ArrayList<T> numbers, T threshold) {
        ArrayList<T> result = new ArrayList<>();
        for (T num : numbers) {
            if (num.compareTo(threshold) > 0) {
                result.add(num);
            }
        }
        return result;
    }

    public static double sumNumbers(ArrayList<? extends Number> numbers) {
        double total = 0.0;
        for (Number num : numbers) {
            total += num.doubleValue();
        }
        return total;
    }

    public static void addNumbers(ArrayList<? super Integer> list) {
        list.add(1);
        list.add(2);
        list.add(3);
    }

    public static void printList(ArrayList<?> list) {
        for (Object item : list) {
            System.out.println(item);
        }
    }

}

