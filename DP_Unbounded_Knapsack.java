public class DP_Unbounded_Knapsack {

    public static int unboundedKnapsack_tabulation(int value[], int weight[], int totalWeight) {
        int n = value.length;
        int dp[][] = new int[n+1][totalWeight+1];
        
        //? Initialization
        for (int i = 0; i < n+1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < totalWeight+1; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < totalWeight+1; j++) {
                if(weight[i-1] <= j) {  //! valid
                    dp[i][j] = Math.max(value[i-1] + dp[i][j-weight[i-1]], dp[i-1][j]);
                } else {    //! invalid
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        printDp(dp);
        return dp[n][totalWeight];
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

    public static void main(String[] args) {
        int value[] = {15, 14, 10, 45, 30};
        int weight[] = {2, 5, 1, 3, 4};
        int totalWeight = 7;
        System.out.println(unboundedKnapsack_tabulation(value, weight, totalWeight));
    }
}
