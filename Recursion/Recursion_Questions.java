package Recursion;
public class Recursion_Questions {

    /*
        For a given integer array of size N. You have to find all the 
        occurrences(indices) of a given key and print them. use a 
        recursive function to solve this problem.
        
        sample input: arr[] = {3, 2, 4, 5, 6, 2, 7, 2, 2}, key = 2
        sample output: 1 5 7 8
    */

    public static void printOccurence(int arr[], int key, int i) {
        if(i == arr.length) {
            return;
        }
        if(arr[i] == key) {
            System.out.print(i + "\t");
        }
        printOccurence(arr, key, i+1);
    }

    /*
        You are given a number(eg- 2019), convert it into a String of
        English like "two zero two nine". Use a recursive function 
        to solve this problem.
        Note: The digits of the number will be in the range 0-9 and the 
        last digit of a number can't be 0.
        Sample input: 1947
        Sample output: "one nine four seven"
    */

    static String digits[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eigth", "nine"};

    public static void printString(int num) {
        if(num == 0) {
            return;
        }

        int lastDigit = num%10;
        printString(num/10);
        System.out.print(digits[lastDigit]+" ");
    }

    /*
        Write a program to find Length of a String using Recursion
    */

    public static int findLength(String str) {
        if(str.length() == 0) {
            return 0;
        }

        return findLength(str.substring(1)) + 1;
    }


    /*
        Tower of Hanoi:-
        You've 3 towers and N disks of different sizes which can slide
        onto any tower. Transfer all disks from source to destination.
        Rules:
            a. Ensure that they are always kept in ascending order.(large at bottom)
            b. Move one disk at a time

        Process:
            Transfer (n-1) disks A to B (x steps)  {using recursion}
            nth disk transfer from A to C (1 steps)
            Transfer (n-1) disks from B to C (y steps)  {using recursion}
                            [x = y]
    */

    public static void towerofHanoi(int n, char src, char dest, char help) {
        if(n == 1) {
            System.out.println("move disk " + n + " from " + src + " to " + dest);
            return;
        }

        towerofHanoi(n-1, src, help, dest);
        System.out.println("move disk " + n + " from " + src + " to " + dest);
        towerofHanoi(n-1, help, dest, src);
    }

    public static void main(String[] args) {

        int arr[] = {3, 2, 4, 5, 6, 2, 7, 2, 2};
        printOccurence(arr, 2, 0);

        int n = 1947;
        printString(n);

        System.out.println(findLength("Ankush"));

        towerofHanoi(3, 'A', 'C', 'B');

    }
}
