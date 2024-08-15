import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OSPlanning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		// Stack
		ArrayDeque<Integer> tasks = new ArrayDeque<>();

		Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(tasks::push);

		// Quene
		ArrayDeque<Integer> threads = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
				.collect(Collectors.toCollection(ArrayDeque::new));

		int num = Integer.parseInt(scanner.nextLine());
		int thread = 0;
		int task = 0;
		while (true) {
			thread = threads.peek();
			task = tasks.peek();

			if (task == num) {
				break;
			} else {
				if (thread >= task) {
					threads.poll();
					tasks.pop();
				} else if (thread < task) {
					threads.poll();
				}
			}
		}
		System.out.printf("Thread with value %d killed task %d%n", thread, task);
		for (Integer element : threads) {
			System.out.print(element + " ");
		}

	}
}