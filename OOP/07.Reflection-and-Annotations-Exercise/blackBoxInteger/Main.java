package blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        Constructor constructor = BlackBoxInt.class.getDeclaredConstructor();
        constructor.setAccessible(true);

        BlackBoxInt blackBoxInt = (BlackBoxInt) constructor.newInstance();

        Method[] methods = blackBoxInt.getClass().getDeclaredMethods();
        Field innerValue = blackBoxInt.getClass().getDeclaredField("innerValue");
        innerValue.setAccessible(true);

        while (!input.equals("END")) {
            String[] tokens = input.split("_");
            String command = tokens[0];
            int value = Integer.parseInt(tokens[1]);

            Method method = Arrays.stream(methods).filter(m -> m.getName().equals(command)).findFirst().orElse(null);
            method.setAccessible(true);
            method.invoke(blackBoxInt, value);

            System.out.println(innerValue.get(blackBoxInt));
            input = sc.nextLine();
        }
    }
}
