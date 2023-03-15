public class DP_Edit_Distance {

    public static int editDistance(String str1, String str2) {  //! O(n * m)
        int n = str1.length(), m = str2.length();

        int dp[][] = new int[n+1][m+1];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < m+1; j++) {
                if(i == 0) dp[i][j] = j;
                if(j == 0) dp[i][j] = i;
            }
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {  //? same
                    dp[i][j] = dp[i-1][j-1];
                } else {    //? different
                    int addition = dp[i][j-1];
                    int deletion = dp[i-1][j];
                    int replace = dp[i-1][j-1];
                    dp[i][j] = Math.min(addition, Math.min(deletion, replace)) + 1;
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";

        System.out.println(editDistance(word1, word2));
    }
}
