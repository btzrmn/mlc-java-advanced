package class09.exercise.StackIterator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.function.Consumer;

public class CustomStack implements Iterable<Integer> {
    private final Deque<Integer> stack;

    public CustomStack() {
        this.stack = new ArrayDeque<>();
    }

    public void push(int num) {
        this.stack.push(num);
    }

    public void pop() {
        if (stack.isEmpty()) {
            System.out.println("No elements");
        } else {
            this.stack.pop();
        }
    }

    public void forEachModified(Consumer<? super Integer> consumer) {
        for (int value : this.stack) {
            consumer.accept(value);
        }
    }

    @Override
    public Iterator<Integer> iterator() {

        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Integer next() {
                return null;
            }
        };
    }
}
