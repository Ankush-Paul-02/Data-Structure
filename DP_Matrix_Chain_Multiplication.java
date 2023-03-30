import java.util.Arrays;

public class DP_Matrix_Chain_Multiplication {

    public static int mcm_recursion(int arr[], int i, int j) {
        if(i == j) return 0;
        int answer = Integer.MAX_VALUE;
        for (int k = i; k <= j-1; k++) {
            int cost1 = mcm_recursion(arr, i, k);   //? Ai....Ak => arr[i-1] x arr[k]
            int cost2 = mcm_recursion(arr, k+1, j); //? Ak+1....Aj => arr[k] x arr[j]
            int cost3 = arr[i-1] * arr[k] * arr[j];
            int finalCost = cost1 + cost2 + cost3;
            answer = Math.min(answer, finalCost);
        }
        return answer;
    } 

    public static int mcm_memoization(int arr[], int dp[][], int i, int j) {
        if(i == j) return 0;
        int answer = Integer.MAX_VALUE;
        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        for (int k = i; k <= j-1; k++) {
            int cost1 = mcm_memoization(arr, dp, i, k);
            int cost2 = mcm_memoization(arr ,dp, k+1, j);
            int cost3 = arr[i-1] * arr[k] * arr[j];
            answer = Math.min(answer, cost1 + cost2 + cost3);
        }
        return dp[i][j] = answer;
    }

    public static int mcm_tabulation(int arr[]) {
        int n = arr.length;
        int dp[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }

        for (int length = 2; length <= n-1; length++) {
            for (int row = 1; row <= n-length; row++) {
                int column = row+length-1;
                dp[row][column] = Integer.MAX_VALUE;
                for (int k = row; k <= column-1; k++) {
                    int cost1 = dp[row][k];
                    int cost2 = dp[k+1][column];
                    int cost3 = arr[row-1] * arr[k] * arr[column];
                    dp[row][column] = Math.min(dp[row][column], cost1 + cost2 + cost3);
                }
            }
        }
        printDp(dp);
        return dp[1][n-1];
    }

    public static void printDp(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 3};
        int n = arr.length;
        System.out.println(mcm_recursion(arr, 1, n-1));

        int dp[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(mcm_memoization(arr, dp, 1, n-1));

        System.out.println(mcm_tabulation(arr));
    }
}
