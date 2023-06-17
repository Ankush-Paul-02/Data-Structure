import java.util.Arrays;

public class Array_Rotate_K {

    public static void swap(int arr[], int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void reverse(int arr[], int left, int right) {
        while(left < right) {
            swap(arr, left++, right--);
        }
    }

    public static void rotate(int nums[], int k) {
        int n = nums.length;
        k = k % n;

        /**
         * Reverse the array
         * 7 6 5 4 3 2 1
         */
        reverse(nums, 0, n-1);
        /**
         * Reverse the first k elements
         * 5 6 7 4 3 2 1
         */
        reverse(nums, 0, k-1);
        /**
         * Reverse the last elements after k
         * 5 6 7 1 2 3 4
         */
        reverse(nums, k, n-1);
        
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};

        rotate(arr, 3);
        System.out.println(Arrays.toString(arr));
    }
}
