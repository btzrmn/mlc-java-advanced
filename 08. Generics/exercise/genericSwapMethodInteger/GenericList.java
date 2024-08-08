package class08.excercise.genericSwapMethodInteger;

import java.util.ArrayList;
import java.util.List;

public class GenericList<T> {
    private final List<T> list;

    public GenericList() {
        this.list = new ArrayList<>();
    }

    public void add(T value) {
        this.list.add(value);
    }

    public void swap(int index1, int index2) {
        T temp = this.list.get(index1);
        this.list.set(index1, this.list.get(index2));
        this.list.set(index2, temp);
    }

    public void print() {
        this.list.forEach(v -> System.out.println(v.getClass().getName() + ": " + v));
    }
}
