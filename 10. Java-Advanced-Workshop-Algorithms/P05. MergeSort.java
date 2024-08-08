import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        input = mergeSort(input);

        for (int i : input) {
            System.out.print(i + " ");
        }
    }

    private static int[] mergeSort(int[] array) {
        if (array.length == 1) {
            return array;
        }

        int halfIndex = array.length / 2;

        int firstArrayLength = halfIndex;
        int secondArrayLength = array.length - halfIndex;

        int[] firstPartition = new int[firstArrayLength];
        int[] secondPartition = new int[secondArrayLength];

        for (int i = 0; i < firstArrayLength; i++) {
            firstPartition[i] = array[i];
        }

        for (int i = firstArrayLength; i < firstArrayLength + secondArrayLength; i++) {
            secondPartition[i - firstArrayLength] = array[i];
        }

        firstPartition = mergeSort(firstPartition);
        secondPartition = mergeSort(secondPartition);

        int mainIndex = 0;

        int firstPartitionIndex = 0;
        int secondPartitionIndex = 0;

        while (firstPartitionIndex < firstArrayLength && secondPartitionIndex < secondArrayLength) {
            if (firstPartition[firstPartitionIndex] < secondPartition[secondPartitionIndex]) {
                array[mainIndex++] = firstPartition[firstPartitionIndex++];
            } else {
                array[mainIndex++] = secondPartition[secondPartitionIndex++];
            }
        }

        while (firstPartitionIndex < firstArrayLength) {
            array[mainIndex++] = firstPartition[firstPartitionIndex++];
        }

        while (secondPartitionIndex < secondArrayLength) {
            array[mainIndex++] = secondPartition[secondPartitionIndex++];
        }

        return array;
    }
}
