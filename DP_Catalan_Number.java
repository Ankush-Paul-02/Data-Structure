public class DP_Catalan_Number {

    public static int catalan_recursion(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }
        int ans = 0;
        for (int i = 0; i <= n-1; i++) {
            ans += catalan_recursion(i) * catalan_recursion(n-i-1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(catalan_recursion(n));
    }
}
