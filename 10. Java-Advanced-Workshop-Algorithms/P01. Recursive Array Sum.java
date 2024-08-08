import java.util.Arrays;
import java.util.Scanner;

public class RecursiveSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] nums = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(sum(nums,0));
    }
    private static int sum(int[] nums, int index){
        if(index == nums.length){
            return 0;
        }
        return nums[index] + sum(nums, index+1);
    }
}
