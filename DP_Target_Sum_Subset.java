public class DP_Target_Sum_Subset {

    public static boolean targetSumSubset_tabulation(int arr[], int targetSum) {   //! O(n * targetSum)
        int n = arr.length;
        boolean dp[][] = new boolean[n+1][targetSum+1];

        //? i = items & j = target sum
        for (int i = 0; i < n+1; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < targetSum+1; j++) {
                int value = arr[i-1];
                //! include
                if(value <= j && dp[i-1][j-value] == true) {
                    dp[i][j] = true;
                }
                //! exclude
                else if(dp[i-1][j] == true) {
                    dp[i][j] = true;
                }
            }
        }
        printDp(dp);
        return dp[n][targetSum];
    }

    public static void printDp(boolean dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {4, 2, 7, 1, 3};
        int targetSum = 10;
        System.out.println(targetSumSubset_tabulation(arr, targetSum));
    }
}