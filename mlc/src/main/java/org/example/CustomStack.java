package org.example;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class CustomStack {
    private static final int INITIAL_CAPACITY = 4;
    private int[] items;
    private int size;
    private int capacity;

    public CustomStack() {
        this.capacity = INITIAL_CAPACITY;
        this.items = new int[INITIAL_CAPACITY];
    }

    public int getSize() {
        return this.size;
    }

    public void push(int element) {
        if (this.size == this.capacity) {
            this.resize();
        }
        this.items[this.size++] = element;
    }

    public int pop() {
        this.checkEmpty();
        int element = this.items[this.size - 1];
        this.size--;
        return element;
    }

    public int peek() {
        this.checkEmpty();
        return this.items[this.size - 1];
    }

    private void checkEmpty() {
        if (this.size == 0) {
            throw new NoSuchElementException("Hooson stack");
        }
    }

    private void resize() {
        this.capacity *= 2;
        int[] copy = new int[this.capacity];
        for (int i = 0; i < this.items.length; i++) {
            copy[i] = items[i];
        }
        this.items = copy;
    }

    public void forEach(Consumer<Integer> consumer) {
        for (int i = 0; i < this.size; i++) {
            consumer.accept(this.items[i]);
        }
    }
}
