public class Backtracking_Knight_Tour {

    /*
     * Given a N*N board with the Knight placed on the first block of an
     * empty board. Moving according to the rules of chess, Knights must 
     * visit each square exactly once. Print the order of each cell in 
     * which they are visited.
     */

    static int n = 8;

    public static void printSolution(int sol[][]) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(int x, int y, int sol[][]) {
        return (x >= 0 && x < n && y >= 0 && y < n && sol[x][y] == -1);
    }

    public static boolean solveKnight() {
        int sol[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sol[i][j] = -1;
            }
        }

        int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};

        // As the knight starts from cell (0, 0)
        sol[0][0] = 0;
        if(!solveKnightUtil(0, 0, 1, sol, xMove, yMove)) {
            System.out.println("Solution doesn't exist");
            return false;
        } else {
            printSolution(sol);
        }
        return true;
    }

    public static boolean solveKnightUtil(int x, int y, int movei, int sol[][], int xMove[], int yMove[]) {
        int next_x, next_y;
        if(movei == n*n) {
            return true;
        }
        for (int i = 0; i < n; i++) {
            next_x = x + xMove[i];
            next_y = y + yMove[i];
            if(isSafe(next_x, next_y, sol)) {
                sol[next_x][next_y] = movei;
                if(solveKnightUtil(next_x, next_y, movei+1, sol, xMove, yMove)) {
                    return true;
                } else {
                    sol[next_x][next_y] = -1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        solveKnight();
    };
}
