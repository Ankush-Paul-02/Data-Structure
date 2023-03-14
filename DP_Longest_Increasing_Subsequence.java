import java.util.Arrays;
import java.util.HashSet;

public class DP_Longest_Increasing_Subsequence {

    public static int lcs(int arr1[], int arr2[]) {
        int n = arr1.length;
        int m = arr2.length;
        int dp[][] = new int[n+1][m+1];

        //? Initialization
        for (int i = 0; i < n+1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < m+1; j++) {
            dp[0][j] = 0;
        }

        //? Bottom up
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if(arr1[i-1] == arr2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    int res1 = dp[i-1][j];
                    int res2 = dp[i][j-1];
                    dp[i][j] = Math.max(res1, res2);
                }
            }
        }
        return dp[n][m];
    }

    public static int lis(int arr1[]) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }

        int arr2[] = new int[set.size()];   //! stored unique elements
        int i = 0;
        for (int x : set) {
            arr2[i++] = x;
        }
        Arrays.sort(arr2);

        return lcs(arr1, arr2);
    }

    public static void main(String[] args) {
        int arr1[] = {50, 3 ,10, 7, 40, 80};
        System.out.println(lis(arr1));
    }
}
