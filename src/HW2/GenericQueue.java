package HW2;

import java.util.ArrayList;

public class GenericQueue<T> {

    private ArrayList<T> queue;

    public GenericQueue() {
        this.queue = new ArrayList<>();
    }

    public void enqueue(T item) {
        queue.add(item);
    }

    public T dequeue() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return null;
        }
        return queue.remove(0);
    }

    public T peek() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty. Cannot peek.");
            return null;
        }
        return queue.get(0);
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }

    @Override
    public String toString() {
        return queue.toString();
    }

}