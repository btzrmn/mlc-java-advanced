package class09.exercise.ListyIterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ListyIterator<T>{
    private List<T> list;
    private int index;

    public ListyIterator(T... elements) {
        this.list = Arrays.asList(elements);
        this.index = 0;
    }

    public boolean move() {
        if (hasNext()) {
            index++;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        if (index < list.size() - 1) {
            return true;
        }
        return false;
    }

    public void print() {
        if (this.list.isEmpty()) {
            throw new IllegalStateException("Invalid Operation!");
        }
        System.out.println(this.list.get(this.index));
    }
}

