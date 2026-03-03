package HW2;

import java.util.ArrayList;
import java.util.Collections;

public class GenericList<T> {

    private ArrayList<T> items;

    public GenericList() {
        this.items = new ArrayList<>();
    }

    public void add(T item) {
        items.add(item);
    }

    public T get(int index) {
        if (index < 0 || index >= items.size()) {
            System.out.println("Index out of bounds.");
            return null;
        }
        return items.get(index);
    }

    public boolean remove(T item) {
        return items.remove(item);
    }

    public int size() {
        return items.size();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void clear() {
        items.clear();
    }

    public boolean contains(T item) {
        return items.contains(item);
    }

    public ArrayList<T> getAll() {
        return new ArrayList<>(items);
    }

    public void addAll(ArrayList<T> other) {
        for (T item : other) {
            items.add(item);
        }
    }

    public <U extends T> void addAllFrom(GenericList<U> other) {
        ArrayList<U> otherItems = other.getAll();
        for (U item : otherItems) {
            items.add(item);
        }
    }

    public void sort() {
        try {
            Collections.sort((ArrayList<Comparable>) (ArrayList<?>) items);
        } catch (ClassCastException e) {
            System.out.println("Cannot sort - elements do not implement Comparable.");
        }
    }

    public T findMax() {
        if (items.isEmpty()) return null;
        try {
            T max = items.get(0);
            for (int i = 1; i < items.size(); i++) {
                if (((Comparable<T>) items.get(i)).compareTo(max) > 0) {
                    max = items.get(i);
                }
            }
            return max;
        } catch (ClassCastException e) {
            System.out.println("Cannot find max - elements do not implement Comparable.");
            return null;
        }
    }

    @Override
    public String toString() {
        return items.toString();
    }

}