package Backtracking;
// import java.util.ArrayList;

public class Backtracking_Arrays {

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    public static void changeArray(int arr[], int index, int val) { // O(n)
        // base case
        if(index == arr.length) {
            printArray(arr);
            return;
        }
        // recursion
        arr[index] = val;
        changeArray(arr, index+1, val+1);   // function call step
        arr[index] = arr[index] - 2;    // backtracking step
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6}; // 3
        changeArray(arr, 0, 1);
        printArray(arr);
    }
}
