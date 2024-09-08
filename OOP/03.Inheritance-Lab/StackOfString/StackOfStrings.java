package class13.StackOfString;

import java.util.ArrayList;

public class StackOfStrings {
    private ArrayList<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String element) {
        this.data.add(element);
    }

    public String pop() {
        if (this.data.isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return this.data.remove(this.data.size() - 1);
    }

    public String peek() {
        if (this.data.isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return this.data.get(this.data.size() - 1);
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }
}
