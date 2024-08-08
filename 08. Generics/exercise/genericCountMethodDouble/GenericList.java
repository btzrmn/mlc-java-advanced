package class08.excercise.genericCountMethodDouble;

import java.util.ArrayList;
import java.util.List;

public class GenericList<T extends Comparable<T>> {
    private final List<T> list;

    public GenericList() {
        this.list = new ArrayList<>();
    }

    public void add(T value) {
        this.list.add(value);
    }

    public int sumOfGreater(T element) {
        int count = 0;
        for (T e : this.list) {
            if (element.compareTo(e) < 0) {
                count++;
            }
        }
        return count;
    }
}
