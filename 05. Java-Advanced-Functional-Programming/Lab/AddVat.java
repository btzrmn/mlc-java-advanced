package class05.lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AddVat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UnaryOperator<Double> vatCalc = x -> x * 1.2;
        List<Double> list = Arrays.stream(sc.nextLine().split(", "))
                .map(e -> vatCalc.apply(Double.parseDouble(e)))
                .collect(Collectors.toList());

        Consumer<Double> printer = x -> System.out.printf("%.2f%n", x);
        System.out.println("Prices with VAT:");
        list.forEach(printer);
    }
}
