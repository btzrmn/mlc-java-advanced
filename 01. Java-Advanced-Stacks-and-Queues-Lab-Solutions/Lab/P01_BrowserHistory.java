import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<String> browser = new ArrayDeque<>();

        String line = scanner.nextLine();

        String current = "";

        while (!line.equals("Home")) {
            if (line.equals("back")) {
                if (!browser.isEmpty()) {
                    current = browser.pop();
                } else {
                    System.out.println("no previous URLs");
                    line = scanner.nextLine();
                    continue;
                }
            } else {
                if (line.equals("forward")) {
                    if (!browser.isEmpty()) {
                        current = browser.pop();
                    } else {
                        System.out.println("no next URLs");
                        line = scanner.nextLine();
                        continue;
                    }
                } else {
                    if (!current.equals("")) {
                        browser.push(current);
                    }
                    current = line;
                }
            }
            System.out.println(current);
            line = scanner.nextLine();
        }

    }
}
