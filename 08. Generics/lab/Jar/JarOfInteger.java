package class08.lab.Jar;

public class JarOfInteger extends Jar<Integer> {
    public Integer get() {
        return this.content.peek();
    }
}
