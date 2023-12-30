package Array;
import java.util.Arrays;

public class Array_Majority_Element {
    public static void main(String[] args) {
        int nums[] = { 2, 2, 1, 1, 1, 2, 2 };

        Arrays.sort(nums);
        int count = 0;

        if(nums.length == 1) {
            System.out.println(nums[0]);
        }

        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i] != nums[i+1]) {
                count = 0;
            } else {
                count++;
            }
            if(count >= nums.length/2) {
                System.out.println(nums[i]);
            }
        }
    }
}