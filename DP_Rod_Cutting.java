public class DP_Rod_Cutting {

    public static int rod_cutting(int length[], int prices[], int totalRodLength) { //! O(n * totalRodLength)
        int n = length.length;
        int dp[][] = new int[n+1][totalRodLength+1];

        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < totalRodLength+1; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < totalRodLength+1; j++) {
                if(length[i-1] <= j) {
                    dp[i][j] = Math.max(prices[i-1] + dp[i][j-length[i-1]], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][totalRodLength];
    }

    public static void main(String[] args) {
        int length[] = {1, 2, 3, 4 ,5, 6, 7, 8};
        int prices[] = {1, 5, 8, 9, 10, 17, 17, 20};
        int totalRodLength = 8;
        System.out.println(rod_cutting(length, prices, totalRodLength));
    }
}
