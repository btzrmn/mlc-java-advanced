package class05.lab;

import java.util.function.*;

public class LambdaExample {
    public static void main(String[] args) {
        int a = 5;
        System.out.println(operation(a, x -> x + 5));
        System.out.println(operation(a, x -> x * 5));
        System.out.println(operation(a, x -> x - 2));

        System.out.println(operation1(5,"hi", (x,y) -> {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < x; i++) {
                str.append(y);
            }
            return str.toString();
        }));


//        Consumer<String> printer = s -> System.out.println(s);
//        Predicate<Integer> isEven = x -> x % 2 == 0;
//
//        Supplier<String> programing = () -> "Hello World";
//
//        Function<String, Integer> parser = s -> Integer.parseInt(s) + 1;
//
//        UnaryOperator<Integer> multiply = x -> x * 2;
//        BiFunction<Integer, String, Integer> add = (x,y) -> x + Integer.parseInt(y);
//        BiConsumer<String , Integer> nameAndAgePrinter = (name, age) -> System.out.printf("%s are %d years old.%n", name, age);
//        BiPredicate<Integer, String> isEqual = (x, y) -> y.equals(x.toString());
//        printer.accept("Hi");
//        System.out.println(isEven.test(2));
//        System.out.println(programing.get());
//        System.out.println(parser.apply("1"));
//        System.out.println(multiply.apply(5));
//        System.out.println(add.apply(2, "5"));
//        nameAndAgePrinter.accept("Ganaa", 28);
//        System.out.println(isEqual.test(2, "2"));
    }

    static int operation(int a, Function<Integer, Integer> func) {
        return func.apply(a);
    }

    static String operation1(int a, String b, BiFunction<Integer, String, String> func) {
        return func.apply(a, b);
    }
}
