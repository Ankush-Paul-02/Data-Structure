import java.util.Arrays;

public class DP_Array_Jumps {

    public static int minimumJumps(int jumps[]) {
        int n = jumps.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        dp[n-1] = 0;

        for (int i = n-2; i >= 0; i--) {
            int steps = jumps[i];
            int answer = Integer.MAX_VALUE;
            for (int j = i+1; j <= i+steps && j < n; j++) {
                if(dp[j] != -1) {
                    answer = Math.min(answer, dp[j] + 1);
                }
            }
            if(answer != Integer.MAX_VALUE) {
                dp[i] = answer;
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();
        return dp[0];
    }

    public static void main(String[] args) {
        int jumps[] = {2, 3, 1, 1, 4};
        System.out.println(minimumJumps(jumps));
    }
}
