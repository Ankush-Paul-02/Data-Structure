public class DP_fibonacci {

    public static int fibonacci_memoization(int n, int dp[]) {  //! O(n)
        if(n == 0 || n == 1) {
            return n;
        }
        if(dp[n] != 0) {   //? fib[n] is already calculated
            return dp[n];
        }
        dp[n] = fibonacci_memoization(n-1, dp) + fibonacci_memoization(n-2, dp);
        return dp[n];
    }

    public static int fibonacci_tabulation(int n) { //! O(n)
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        int dp[] = new int[n+1];
        System.out.println(fibonacci_memoization(n, dp));
        System.out.println(fibonacci_tabulation(n));
    }
}
