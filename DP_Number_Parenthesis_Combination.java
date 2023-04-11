public class DP_Number_Parenthesis_Combination {
    
    static int ans = 0;

    public static int helper(int left, int right) {
        if(left == 0 && right == 0) {
            ans++;
        }
        if(left > right) return 0;

        if(left > 0) {
            helper(left-1, right);
        }
        if(right > 0) {
            helper(left, right-1);
        }
        return ans;
    }

    private static int countWays(int n) {
        //? If n is odd no possible valid parenthesis
        // return (n & 1) != 0 ? 0 : helper(n/2, n/2);
        if((n & 1) != 0) {
            return 0;
        }
        return helper(n/2, n/2);
    }

    public static void main(String[] args) {
        /*
         *  Given N number of parenthesis(pair of opening and closing parenthesis)
         *  you have to count all the valid combinations of the parenthesis.
         */
        int n = 4;
        System.out.println(countWays(n));
    }
}
