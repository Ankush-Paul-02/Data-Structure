package Graph;
public class Graph_Size_Largest_Region_Boolean_Matrix {

    static int Row, Column, count;

    static boolean isSafe(int [][]arr, int row, int column, boolean visited[][]) {
        return (
            (row >= 0) && (row < Row) && (column >= 0)
            && (column < Column) && (arr[row][column] == 1 && !visited[row][column])
        );
    }

    static void dfs(int arr[][], int row, int column, boolean visited[][]) {
        int rowNbr[] = {-1, -1, -1, 0, 0, 1, 1, 1};
        int colNbr[] = {-1, 0, 1, -1, 1, -1, 0, 1};

        visited[row][column] = true;
        for (int i = 0; i < 8; i++) {
            if(isSafe(arr, row+rowNbr[i], column+colNbr[i], visited)) {
                count++;
                dfs(arr, row+rowNbr[i], column+colNbr[i], visited);
            }
        }
    }

    static int largestRegion(int arr[][]) { // O(r*c)
        boolean visited[][] = new boolean[Row][Column];
        int result = 0;
        for (int i = 0; i < Row; i++) {
            for (int j = 0; j < Column; j++) {
                if(arr[i][j] == 1 && !visited[i][j]) {
                    count = 1;
                    dfs(arr, i, j, visited);
                    result = Math.max(result, count);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        /*
         *  We have a matrix where each cell contains either '0' or '1',
         *  and any cell containing a 1 is called a fixed cell. Two cells 
         *  are said to be connected if they are adjacent to each other 
         *  horizontally, vertical or diagonally. If one or more filled 
         *  cells are also connected, they form a region. Find the size of
         *  the size of the largest region.
         */

        int arr[][] = {
            {0, 0, 1, 1, 0},
            {0, 0, 1, 1, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1}
        }; 

        Row = 4;
        Column = 5;
        
        System.out.println(largestRegion(arr));
    }
}
