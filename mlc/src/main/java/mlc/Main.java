package mlc;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    @Author(name = "Batzorig")
    public static void main(String[] args) {
        printMethodsByAuthor(Main.class);
    }

    @Author(name = "Gan-Erdene")
    public static void printMethodsByAuthor(Class<?> cl) {
        Map<String, List<String>> map = new HashMap<>();
        Method[] methods = cl.getDeclaredMethods();

        for (Method method : methods) {
            Author author = method.getAnnotation(Author.class);
            if (author != null) {
                map.putIfAbsent(author.name(), new ArrayList<>());
                map.get(author.name()).add(method.getName() + "()");
            }
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            System.out.printf("%s: %s\n", entry.getKey(), String.join(", ", entry.getValue()));
        }
    }

    @Author(name = "MLC")
    public void test() {

    }
}
