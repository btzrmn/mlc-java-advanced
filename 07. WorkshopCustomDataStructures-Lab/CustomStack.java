import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class CustomStack {
  private static final int INITIAL_CAPACITY = 4;
  private int size;
  private int capacity;
  private int[] items;

  public CustomStack() {
    this.items = new int[INITIAL_CAPACITY];
    this.size = 0;
    this.capacity = INITIAL_CAPACITY;
  }

  public void checkEmpty() {
    if (this.size == 0) {
      throw new NoSuchElementException("CustomStack is empty");
    }
  }

  private void resize() {
    this.capacity *= 2;
    int[] copy = new int[this.capacity];

    for (int i = 0; i < this.items.length; i++) {
      copy[i] = this.items[i];
    }
    this.items = copy;
  }

  public void push(int element) {
    if (this.capacity == this.size) {
      this.resize();
    }
    this.items[size++] = element;
  }

  public int pop() {
    checkEmpty();
    int element = this.items[size - 1];
    this.size--;
    return element;
  }

  public int peek() {
    checkEmpty();
    return this.items[size - 1];
  }

  public void forEach(Consumer<Integer> consumer) {
    for (int i = 0; i < this.size; i++) {
      consumer.accept(this.items[i]);
    }
  }

  public int getSize() {
    return size;
  }

  public String toString() {
    return Arrays.toString(items);
  }
}
