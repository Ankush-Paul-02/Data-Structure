public class Array2D_DiagonalSum {

    public static int diagonalSum(int arr[][]) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][i];
            if(i != arr.length-1-i) {
                sum += arr[i][arr.length-i-1];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int arr[][] = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        System.out.println(diagonalSum(arr));
    }
}
