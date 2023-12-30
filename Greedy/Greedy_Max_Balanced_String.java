package Greedy;
public class Greedy_Max_Balanced_String {
    static int balancedPartition(String str, int n) {
        if(n == 0) {
            return 0;
        }
        int l = 0, r = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if(str.charAt(i) == 'L') {
                l++;
            } else {
                r++;
            }
            if(l == r) {
                ans++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        /*
         *  we've balanced string str of size n with an equal number of
         *  L and R, the task is to find a maximum number x, such that
         *  a given string can be partitioned into x balanced substring.
         *  A string is called to be balanced if the number of L's and 
         *  R's is equal
         */
        String str = "LRRRRLLRLLRL";
        System.out.println(balancedPartition(str, str.length()));
    }
}
