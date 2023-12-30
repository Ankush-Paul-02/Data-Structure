package DP;
public class DP_0_1_Knapsack {

    public static int knapSack_recursion(int value[], int weight[], int W, int n) { //! O(2^n)
        if(W == 0 || n == 0) {
            return 0;
        }
        if(weight[n-1] <= W) {  //! valid
            //? Include
            int answer1 = value[n-1] + knapSack_recursion(value, weight, W-weight[n-1], n-1);
            //? Exclude
            int answer2 = knapSack_recursion(value, weight, W, n-1);
            return Math.max(answer1, answer2);
        } else {    //! not valid
            //? Exclude
            return knapSack_recursion(value, weight, W, n-1);
        }
    }

    public static int knapSack_memoization(int value[], int weight[], int W, int n, int dp[][]) {   //! O(n * W)
        if(W == 0 || n == 0) {
            return 0;
        }
        if(dp[n][W] != -1) {
            return dp[n][W];
        }
        if(weight[n-1] <= W) {  //! valid
            //? Include
            int answer1 = value[n-1] + knapSack_memoization(value, weight, W-weight[n-1], n-1, dp);
            //? Exclude
            int answer2 = knapSack_memoization(value, weight, W, n-1, dp);
            dp[n][W] = Math.max(answer1, answer2);
            return dp[n][W];
        } else {    //! not valid
            //? Exclude
            dp[n][W] = knapSack_memoization(value, weight, W, n-1, dp);
            return dp[n][W];
        }
    }

    public static void printDp(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int knapSack_tabulation(int value[], int weight[], int W) {
        int dp[][] = new int[value.length+1][W+1];
        for (int i = 0; i < dp.length; i++) {   //? 0th Column
            dp[i][0] = 0;
        }
        for (int i = 0; i < dp[0].length; i++) {    //? 0th Row
            dp[0][i] = 0;
        }

        for (int i = 1; i < value.length+1; i++) {
            for (int j = 1; j < W+1; j++) {
                int val = value[i-1];   //? value of ith item
                int wet = weight[i-1];  //? weight of ith item

                if(wet <= j) {  //! valid
                    int includeProfit = val + dp[i-1][j-wet];
                    int excludeProfit = dp[i-1][j];
                    dp[i][j] = Math.max(includeProfit, excludeProfit);
                } else {    //! invalid 
                    int excludeProfit = dp[i-1][j];
                    dp[i][j] = excludeProfit;
                }
            }
        }
        printDp(dp);
        return dp[value.length][W];
    }

    public static void main(String[] args) {
        int value[] = {15, 14, 10, 45, 30};
        int weight[] = {2, 5, 1, 3, 4};
        int W = 7;
        System.out.println(knapSack_recursion(value, weight, W, value.length));

        int dp[][] = new int[value.length+1][W+1]; 
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(knapSack_memoization(value, weight, W, value.length, dp));

        System.out.println(knapSack_tabulation(value, weight, W));
    }
}