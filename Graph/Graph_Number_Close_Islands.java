package Graph;
public class Graph_Number_Close_Islands {

    static void dfs(int matrix[][], boolean visited[][], int x, int y, int n, int m, boolean hasCornerCell) {   //! O(n*m)
        if(x < 0 || y < 0 || x >= n || y >= m || visited[x][y] == true || matrix[x][y] == 0) {
            return;
        }

        if(x == 0 || y == 0 || x == n-1 || y == m-1) {
            if(matrix[x][y] == 1) {
                hasCornerCell = true;
            }
        }

        visited[x][y] = true;

        dfs(matrix, visited, x+1, y, n, m, hasCornerCell);
        dfs(matrix, visited, x, y+1, n, m, hasCornerCell);
        dfs(matrix, visited, x-1, y, n, m, hasCornerCell);
        dfs(matrix, visited, x+1, y, n, m, hasCornerCell);
    }

    static int countClosedIsland(int matrix[][], int n, int m) {
        boolean visited[][] = new boolean[n][m];

        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(i != 0 && j != 0 && i != n-1 && j != m-1 && matrix[i][j] == 1 && visited[i][j] == false) {
                    boolean hasCornerCell = false;
                    dfs(matrix, visited, i, j, n, m, hasCornerCell);
                    if(!hasCornerCell) {
                        result++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        /*
         *  We have a binary matrix mat[][] of dimensions NXM such that
         *  1 denotes land and 0 denotes water. Find the number of closed
         *  islands in the given matrix.
         *  A closed island is known as the group of 1s that is surrounded
         *  by only 0s on all the four sides(excluding diagonals). If any 1
         *  is at the edges of the given matrix then it is not considered as
         *  the part of the connected island as it is not surrounded by all 0's
         */

        int N = 5, M = 8;

        int matrix[][] = {
            {0, 0, 0, 0, 0, 0, 0, 1},
            {0, 1, 1, 1, 1, 0, 0, 1},
            {0, 1, 0, 1, 0, 0, 0, 1},
            {0, 1, 1, 1, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 1}
        };

        System.out.println(countClosedIsland(matrix, N, M));
    }
}
