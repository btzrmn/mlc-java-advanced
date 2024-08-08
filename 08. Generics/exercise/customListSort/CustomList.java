package class08.excercise.customListSort;

import java.util.ArrayList;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private final List<T> list;

    public CustomList() {
        this.list = new ArrayList<>();
    }

    public void add(T value) {
        this.list.add(value);
    }

    public T remove(int index) {
        return this.list.remove(index);
    }

    public boolean contains(T element) {
        return this.list.contains(element);
    }

    public void swap(int index1, int index2) {
        T temp = this.list.get(index1);
        this.list.set(index1, this.list.get(index2));
        this.list.set(index2, temp);
    }

    public int countGreaterThan(T element) {
        int count = 0;
        for (T e : this.list) {
            if (element.compareTo(e) < 0) {
                count++;
            }
        }
        return count;
    }

    public T getMin() {
        T min = this.list.get(0);
        for (int i = 1; i < this.list.size(); i++) {
            T current = this.list.get(i);
            if (current.compareTo(min) < 0) {
                min = current;
            }
        }
        return min;
    }

    public T getMax() {
        T max = this.list.get(0);
        for (int i = 1; i < this.list.size(); i++) {
            T current = this.list.get(i);
            if (current.compareTo(max) > 0) {
                max = current;
            }
        }
        return max;
    }

    public void print() {
        this.list.forEach(v -> System.out.println(v));
    }

    public int size() {
        return this.list.size();
    }

    public T get(int index) {
        return this.list.get(index);
    }
}
