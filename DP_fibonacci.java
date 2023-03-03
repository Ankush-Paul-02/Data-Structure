public class DP_fibonacci {

    public static int fibonacci(int n, int dp[]) {
        if(n == 0 || n == 1) {
            return n;
        }
        if(dp[n] != 0) {   //? fib[n] is already calculated
            return dp[n];
        }
        dp[n] = fibonacci(n-1, dp) + fibonacci(n-2, dp);
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        int dp[] = new int[n+1];
        System.out.println(fibonacci(n, dp));
    }
}