public class DP_Counting_Trees {

    public static int  countBST(int nodes) {
        int dp[] = new int[nodes+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < nodes + 1; i++) {
            //? Ci -> BST (i nodes) -> dp(i)
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];  //! leftSubTree = dp[j], rightSubTree = dp[i-j-1]
            }
        }
        return dp[nodes];
    }

    public static void main(String[] args) {
        int nodes = 4;
        System.out.println(countBST(nodes));
    }
}
