import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;

public class e08_HotPotato {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] names = reader.readLine().split(" ");
        int num = Integer.parseInt(reader.readLine());
        ArrayDeque<String> children = new ArrayDeque<>();
        for (int i = 0; i < names.length; i++) {
            children.offer(names[i]);
        }
        while (children.size() > 1){
            for (int i = 0; i < num; i++) {
                String rotate = children.poll();
                children.offer(rotate);
            }
            System.out.println("Removed " + children.pollLast());

        }

        System.out.println("Last is " + children.poll());

    }
}
