package class08.lab.Scale;

public class Main {
    public static void main(String[] args) {
        Scale<Integer> scale = new Scale<>(3,4);
        System.out.println(scale.getHeavier());
    }
}
