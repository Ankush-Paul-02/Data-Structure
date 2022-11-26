import java.util.ArrayList;
import java.util.Arrays;

public class Array_Kadane {

    // for checking all elements are -ve or not
    public static boolean isAllNeg(int nums[]) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < 0) {
                list.add(nums[i]);
            }
        }
        if(list.size() == nums.length) {
            return true;
        }
        return false;
    }

    public static void Kadanes(int nums[]) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        if(isAllNeg(nums) == false) {
            for (int i = 0; i < nums.length; i++) {
                currSum += nums[i];
                if (currSum < 0) {
                    currSum = 0;
                }
                maxSum = Math.max(maxSum, currSum);
            }
        } else {
            Arrays.sort(nums);
            maxSum = nums[nums.length-1];
        }
        System.out.println("Max sub array sum is: " + maxSum);
    }
    public static void main(String[] args) {
        int num1[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        Kadanes(num1);
        int num2[] = {-2, -4, -3, -1, -5};
        Kadanes(num2);
    }
}
