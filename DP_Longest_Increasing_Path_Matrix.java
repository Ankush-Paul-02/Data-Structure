import java.util.Arrays;

public class DP_Longest_Increasing_Path_Matrix {    //! O(n^2)

    static int LIP(int dp[][], int arr[][], int n, int m, int x, int y) {
        if(dp[x][y] < 0) {
            int result = 0;
            if(x == n-1 && y == m-1) {
                return dp[x][y] = 1;
            }
            if(x == n-1 || y == m-1) {
                result = 1;
            }
            if(x+1 < n && arr[x][y] < arr[x+1][y]) {
                result = 1 + LIP(dp, arr, n, m, x+1, y);
            }
            if(y+1 < m && arr[x][y] < arr[x][y+1]) {
                result = Math.max(result, 1 + LIP(dp, arr, n, m, x, y+1));
            }
            dp[x][y] = result;
        }
        return dp[x][y];
    }

    static int wrapper(int arr[][], int n, int m) {
        int dp[][] = new int[10][10];
        for (int i = 0; i < 10; i++) {
            Arrays.fill(dp[i], -1);
        }
        return LIP(dp, arr, n, m, 0, 0);
    }

    public static void main(String[] args) {
        /*
         *  We have a matrix of N rows and M columns. From m[i][j], we
         *  can move to m[i+1][j], if m[i+1][j] > m[i][j], or can move 
         *  to m[i][j+1] if m[i][j+1] > m[i][j]. The task is to print
         *  the longest path length if we start from (0,0)
         */

        int N = 4, M = 4;
        
        int arr[][] = {
            {1, 2, 3, 4},
            {2, 2, 3, 4},
            {3, 2, 3, 4},
            {4, 5, 6, 7},
        };

        System.out.println(wrapper(arr, N, M));
    }
}
