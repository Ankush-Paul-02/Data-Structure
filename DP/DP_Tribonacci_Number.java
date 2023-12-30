package DP;
class DP_Tribonacci_Number {

    public static int tribonacciNumber(int n) { //! O(n)
        int dp[] = new int[n+1];
        dp[0] = dp[1] = 0;
        dp[2] = 1;

        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        for (int i = 0; i < n; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(tribonacciNumber(20));
    }
}