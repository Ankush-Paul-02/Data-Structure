public class Backtracking_Rat_Maze {

    /*
     * Rat in a Maze
     * You are given a starting position for a rat which is stuck in a 
     * maze at an initial point (0,0). The maze would be given in the form
     * of a square matrix of order N*N where the cells with value 0 represented 
     * the maze's blocked locations while value 1 is the open/available 
     * path that rat can take to reach its destination.The rat's destination
     * is at (N-1, N-1).
     * Your task is to find all the posible paths that the rat can take to
     * reach from source to destination in the maze.
     * The posible direction that it can take to move in the maze are 'U'(up)
     * i.e (x,y-1), 'D'(down)(x, y+1), 'L'(left) i.e (x-1, y), 'R'(right) i.e (x+1, y)
     */

    public static boolean ratPath(int maze[][]) {
        int n = maze.length;
        int sol[][] = new int[n][n];
        if(solveMazeUtil(maze, 0, 0, sol) == false) {
            System.out.println("Solution doesn't exist");
            return false;
        }
        printMaze(sol);
        return true;
    }

    public static boolean solveMazeUtil(int maze[][], int x, int y, int sol[][]) {
        if(x == maze.length-1 && y == maze.length-1 && maze[x][y] == 1) {
            sol[x][y] = 1;
            return true;
        }

        // check if maze[x][y] is valid or not
        if(isSafe(maze, x, y) == true) {
            if(sol[x][y] == 1) {
                return false;
            }
            sol[x][y] = 1;
            if(solveMazeUtil(maze, x+1, y, sol)) {
                return true;
            } 
            if(solveMazeUtil(maze, x, y+1, sol)) {
                return true;
            }
            sol[x][y] = 0;
            return false;
        }
        return false;
    }

    public static boolean isSafe(int maze[][], int x, int y) {
        
        return (x >= 0 && x < maze.length && y >= 0 && y < maze.length && maze[x][y] == 1);
    }

    public static void printMaze(int maze[][]) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze.length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int maze[][] =
        {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1}
        };
        ratPath(maze);
    }
}
