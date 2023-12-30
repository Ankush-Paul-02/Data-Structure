package Greedy;
import java.util.Arrays;

public class Greedy_Absolute_Diff_Pair {
    public static void main(String[] args) {
        /*
         * Given two arrays A and B of equal length n. Pair each element
         * of array A to an element in array B, such that sum S of absolute 
         * differences od all the pairs is min.
         */

        int arr1[] = {4, 1, 8, 7};
        Arrays.sort(arr1);
        int arr2[] = {2, 3, 6, 5};
        Arrays.sort(arr2);

        int minAbsoluteDiff = 0;

        for (int i = 0; i < arr2.length; i++) {
            minAbsoluteDiff += Math.abs(arr1[i] - arr2[i]);
        }

        System.out.println(minAbsoluteDiff);    // O(nlogn)
    }
}
