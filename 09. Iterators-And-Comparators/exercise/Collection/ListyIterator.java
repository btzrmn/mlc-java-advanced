package class09.exercise.Collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ListyIterator<T> implements Iterable<T> {
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

    public void printAll() {
        this.forEach(x -> System.out.print(x + " "));
        System.out.println();
    }

    @Override
    public void forEach(Consumer<? super T> consumer) {
        this.list.forEach(consumer::accept);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int itIndex;

            @Override
            public boolean hasNext() {
                return this.itIndex < list.size() - 1;
            }

            @Override
            public T next() {
                itIndex++;
                return list.get(itIndex);
            }
        };
    }
}
