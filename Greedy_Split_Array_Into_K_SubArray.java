public class Greedy_Split_Array_Into_K_SubArray {

    public static int ans = 10000000;

    public static void solve(int arr[], int n, int k, int index, int sum, int maxSum) {
        if(k == 1) {
            maxSum = Math.max(maxSum, sum);
            sum = 0;
            for (int i = index; i < n; i++) {
                sum += arr[i];
            }
            maxSum = Math.max(maxSum, sum);
            ans = Math.min(maxSum, ans);
            return;
        } 
        sum = 0;
        for (int i = index; i < n; i++) {
            sum += arr[i];
            maxSum = Math.max(maxSum, sum);
            solve(arr, n, k-1, i+1, sum, maxSum);
        }
    }

    public static void main(String[] args) {
        /*
         * We have an Array[] of N elements and a number K.(1<=K<=N).
         *  Split the given array into K subarrays (theymustcoveralltheelements). 
         * The maximum sub array sum achievable to K subarrays formed must be 
         * the minimum possible. Find that possible subarray sum
         */

        int arr[] = {1, 2, 3, 4};
        int k = 3;
        int n = 4;
        solve(arr, n, k, 0, 0, 0);
        System.out.println(ans);
    }
}
