public class Backtracking_Grid_Ways {

    /*
     * Find number of ways to reach from (0, 0) to (N-1, M-1) in a
     * NxM Grid. Allowd moves - right or down.
     */

    public static int gridWays(int i, int j, int n, int m) {    // O(2^(N+M))
        // base case
        if(i == n-1 && j == m-1) {
            return 1;
        } else if(i == n || j == m) {
            return 0;
        }
        // recursion
        int way1 = gridWays(i+1, j, n, m);
        int way2 = gridWays(i, j+1, n, m);
        return way1 + way2;
    }

    public static int optimizedGridWays(int n, int m) {
        return fact(n-1+m-1)/(fact(n-1) * fact(m-1));
    }

    public static int fact(int n) {
        if(n == 0) {
            return 1;
        }
        return n * fact(n-1);
    }
    public static void main(String[] args) {
        int n = 3, m = 3;
        System.out.println(gridWays(0, 0, n, m));
        System.out.println(optimizedGridWays(n, m));
    }
}
