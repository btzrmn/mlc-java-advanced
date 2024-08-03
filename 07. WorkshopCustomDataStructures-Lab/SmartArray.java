import java.util.Arrays;
import java.util.function.Consumer;

//[]
public class SmartArray {
  private static final int INITIAL_CAPACITY = 4;
  private int size;
  private int capacity;
  private int[] data;

  public SmartArray() {
    this.data = new int[INITIAL_CAPACITY];
    this.capacity = INITIAL_CAPACITY;
//    this.size = 0;
  }

  public String toString() {
    return Arrays.toString(data);
  }

  private void resize() {
    this.capacity *= 2;
    int[] copy = new int[this.capacity];

    for (int i = 0; i < this.data.length; i++) {
      copy[i] = this.data[i];
    }
    this.data = copy;
  }

  public void add(int element) {
    if (this.capacity == this.size) {
      this.resize();
    }
    this.data[size++] = element;
  }

  public int get(int index) {
    this.checkIndex(index);
    return this.data[index];
  }

  private void shift(int index) {
    for (int i = index; i < this.size; i++) {
      this.data[i] = this.data[i + 1];
    }
    this.data[size - 1] = 0;
  }

  private void shiftRight(int index) {
    for (int i = this.size - 1; i > index; i--) {
      this.data[i] = this.data[i - 1];
    }
  }

  public void add(int index, int element) {
    checkIndex(index);
    if (index == this.size - 1) {
      this.add(index);
    } else {
      if (this.capacity == this.size) {
        this.resize();
      }
      this.size++;
      shiftRight(index);
      this.data[index] = element;
    }
  }

  public boolean contains(int element) {
    for (int i = 0; i < this.size; i++) {
      if (element == this.data[i])
        return true;

    }
    return false;
  }

  public void forEach(Consumer<Integer> consumer) {
    for (int i = 0; i < size; i++) {
      consumer.accept(data[i]);
    }
  }

  private void shrink() {
    this.capacity /= 2;
    int[] copy = new int[this.capacity];
    for (int i = 0; i < this.size; i++) {
      copy[i] = this.data[i];
    }
    this.data = copy;
  }

  public int remove(int index) {
    checkIndex(index);
    int element = this.data[index];
    this.shift(index);
    this.size--;
    if (this.size <= this.capacity / 4) {
      this.shrink();
    }
    return element;
  }

  private void checkIndex(int index) {
    if (index < 0 || index >= this.size) {
      String message = String.format("Index %d out of bounds for length %d", index, this.size);
      throw new IndexOutOfBoundsException(message);
    }
  }

  public int getSize() {
    return size;
  }
}
