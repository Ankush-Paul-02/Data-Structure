public class DP_WildCard_Matching {

    public static boolean isMatch(String str, String pattern) { //! O(n * m)
        int n = str.length();
        int m = pattern.length();
        boolean dp[][] = new boolean[n+1][m+1];

        //? Initialization
        dp[0][0] = true;
        //? Pattern = " "
        for (int i = 1; i < n+1; i++) {
            dp[i][0] = false;
        } 
        //? String = " "
        for (int j = 1; j < m+1; j++) {
            if(pattern.charAt(j-1) == '*') {
                dp[0][j] = dp[0][j-1];
            }
        }

        //? Bottom up
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                //? ith char = jth char || jth char == ?
                if(str.charAt(i-1) == pattern.charAt(j-1) || pattern.charAt(j-1) == '?') {
                    dp[i][j] = dp[i-1][j-1];
                } else if(pattern.charAt(j-1) == '*') {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];  //? last char match || ignore
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        String str = "baaabab";
        String pattern = "*****ba*****ab";
        System.out.println(isMatch(str, pattern));
    }
}
