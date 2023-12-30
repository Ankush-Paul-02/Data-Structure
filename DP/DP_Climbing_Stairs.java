package DP;
import java.util.Arrays;

public class DP_Climbing_Stairs {

    public static int countWays(int stairs) {   //! O(2^n)
        if(stairs == 0) return 1;
        if(stairs < 0) return 0;
        return countWays(stairs - 1) + countWays(stairs - 2); 
    }

    public static int countWays_memoization(int stairs, int dp[]) {   //! O(n)
        if(stairs == 0) return 1;
        if(stairs < 0) return 0;
        
        if(dp[stairs] != -1) {
            return dp[stairs];
        }

        dp[stairs] = countWays(stairs - 1) + countWays(stairs - 2); 
        return dp[stairs];
    }

    public static int countWays_tabulation(int stairs) {
        int dp[] = new int[stairs+1];
        dp[0] = 1;
        for (int i = 1; i <= stairs; i++) {
            if(i == 1) {
                dp[i] = dp[i-1];
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[stairs];
    }

    public static void main(String[] args) {
        int stairs = 5;  //! n = 3 => 3 & n = 4 => 5 then n = 5 => 8
        //? Recursion
        System.out.println("Total number of ways: " + countWays(stairs));

        //? Memoization
        int dp[] = new int[stairs+1];
        Arrays.fill(dp, -1);
        System.out.println("Total number of ways: " + countWays_memoization(stairs, dp));

        //? Tabulation
        System.out.println("Total number of ways: " + countWays_tabulation(stairs));
    }
}
