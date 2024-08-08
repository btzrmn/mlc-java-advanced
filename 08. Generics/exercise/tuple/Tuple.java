package class08.excercise.tuple;

public class Tuple<K, V> {
    private K key;
    private V value;

    public Tuple(K key, V value) {
        this.key = key;
        this.value = value;
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

    public void print() {
        System.out.print(key);
        System.out.print(" -> ");
        System.out.print(value);
        System.out.println();
    }
}
