package DP;
public class DP_String_Conversion {

    public static int lcs(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        int dp[][] = new int[n+1][m+1];

        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < m+1; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[n][m];
    }

    public static int stringConversion(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        int lcs = lcs(str1, str2);
        int deleteOperations = Math.abs(lcs - n);
        int additionOperations = Math.abs(lcs - m);
        return deleteOperations + additionOperations;
    }

    public static void main(String[] args) {
        /* 
         * Convert String1 to string2 with only insertion and deletion.
         * print the number of insertion and deletions.
         */

        String str1 = "abcdef";
        String str2 = "abcde"; 

        System.out.println(stringConversion(str1, str2));
    }
}
