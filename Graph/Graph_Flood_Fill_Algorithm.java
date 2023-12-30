package Graph;
public class Graph_Flood_Fill_Algorithm {   

    public static void floodFillUtil (int image[][], int startRow, int startColumn, int color, boolean isVisited[][], int originalColor) { //! O(m*n)       
        if(startRow < 0 || startColumn < 0 || startRow >= image.length || startColumn >= image[0].length || isVisited[startRow][startColumn] || image[startRow][startColumn] != originalColor) {
            return;
        }
        image[startRow][startColumn] = color;
        // left
        floodFillUtil(image, startRow, startColumn-1, color, isVisited, originalColor);
        // right
        floodFillUtil(image, startRow, startColumn+1, color, isVisited, originalColor);
        // up
        floodFillUtil(image, startRow-1, startColumn, color, isVisited, originalColor);
        // down
        floodFillUtil(image, startRow+1, startColumn, color, isVisited, originalColor);
    }

    public static int[][] floodFill (int image[][], int startRow, int startColumn, int color) {
        boolean isVisited[][] = new boolean[image.length][image[0].length];
        floodFillUtil(image, startRow, startColumn, color, isVisited, image[startRow][startColumn]);
        return image;
    }

    public static void main(String[] args) {
        /*
         *  Given a mxn integer grid image where image[i][j] represents
         *  the pixel value of the image. You are also given three integers 
         *  sr, sc, and color. You should perform a flood fill on the image
         *  starting from the pixel image[sr][sc].
         *  To perform a flood fill, consider the starting pixels connected 
         *  4-directionally to the starting pixel of the same color as the 
         *  starting pixel, plus any pixels connected 4-directionally to
         *  those pixels(also with the same color), and so on. Replace the 
         *  color of all the aforementioned pixels with color.
         */

        int image[][] = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };
        int arr[][] = floodFill(image, 1, 1, 2);
        for (int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        
    }
}
