public class DP_LCS {

    public static int lcs_recursion(String str1, String str2, int n, int m) {
        if(n == 0 || m == 0) return 0;

        if(str1.charAt(n-1) == str2.charAt(m-1)) {
            return lcs_recursion(str1, str2, n-1, m-1) + 1;
        } else {
            int res1 = lcs_recursion(str1, str2, n-1, m);
            int res2 = lcs_recursion(str1, str2, n, m-1);
            return Math.max(res1, res2);
        }
    }

    public static void main(String[] args) {
        String str1 = "abcdge";
        String str2 = "abedg";
        System.out.println(lcs_recursion(str1, str2, str1.length(), str2.length()));
    }
}
