public class Backtracking_N_Queens {

    static int count = 0;

    public static boolean isSafe(char board[][], int row, int col) {
        // vertically up
        for(int i = row-1; i >= 0; i--) {
            if(board[i][col] == 'Q') {
                return false;
            }
        }
        // diagonal left up
        for(int i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }
        // diagonally right up
        for(int i = row-1, j = col+1; i >= 0 && j < board.length; i--, j++) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void nQueens(char board[][], int row) {   // O(n!)
        // Base case
        if (row == board.length) {
            count++;
            printBoard(board);
            return;
        }

        // column loop
        for (int j = 0; j < board.length; j++) {
            if(isSafe(board, row, j)) {
                board[row][j] = 'Q';
                nQueens(board, row+1);
                board[row][j] = 'X'; // backtracking
            } 
        }

        /*
            for get only 1 solution if posible
            We've to make the funtion boolean type also
            
            for (int j = 0; j < board.length; j++) {
                if(isSafe(board, row, j)) {
                    board[row][j] = 'Q';
                    if(nQueens(board, row+1)) {
                        return true;
                    };
                    board[row][j] = 'X'; // backtracking
                } 
            }
            return false;
        */
    }

    public static void printBoard(char board[][]) {
        System.out.println("------Chess board------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 4;
        char board[][] = new char[n][n];
        // Initialize
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] ='X';
            }
        }
        nQueens(board, 0);
        System.out.println("Total ways to solve " + n + " Queen problem: " + count);
    }
}
