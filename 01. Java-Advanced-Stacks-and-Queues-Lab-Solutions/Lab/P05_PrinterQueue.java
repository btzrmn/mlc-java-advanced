import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fileName = scanner.nextLine();

        Deque<String> files = new ArrayDeque<>();

        while (!fileName.equals("print")) {
            if(fileName.equals("cancel")){
                if(!files.isEmpty()){
                    System.out.println("Canceled " + files.pollFirst());
                }else{
                    System.out.println("Printer is on standby");
                }
            }else{
                files.offer(fileName);
            }

            fileName = scanner.nextLine();
        }

        while (!files.isEmpty()){
            System.out.println(files.pollFirst());
        }
    }
}
