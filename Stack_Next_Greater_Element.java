import java.util.*;

/*
 * 1. Next Greater Right
 * 2. Next Greater Left
 * 2. Next Smaller Right
 * 2. Next Smaller Left
 */

public class Stack_Next_Greater_Element {
    public static void main(String[] args) {
        int arr[]= {11, 72, 30, 1, 15, 60};
        Stack<Integer> stack = new Stack<>();
        int nextGreater[] = new int[arr.length];

        for (int i = arr.length-1; i >= 0; i--) {
            // while
            while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            // if else
            if(stack.isEmpty()) {
                nextGreater[i] = -1;
            } else {
                nextGreater[i] = arr[stack.peek()];
            }
            // push
            stack.push(i);
        }

        for (int i = 0; i < nextGreater.length; i++) {
            System.out.print(nextGreater[i] + " ");
        }
        System.out.println();
    }
}
