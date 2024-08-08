package class08.excercise.threeuple;

public class Threeuple<K, V, T> {
    private K key;
    private V value;
    private T value1;

    public Threeuple(K key, V value, T value1) {
        this.key = key;
        this.value = value;
        this.value1 = value1;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public T getValue1() {
        return value1;
    }

    public void setValue1(T value1) {
        this.value1 = value1;
    }

    public void print() {
        System.out.print(key);
        System.out.print(" -> ");
        System.out.print(value);
        System.out.print(" -> ");
        System.out.print(value1);
        System.out.println();
    }
}
