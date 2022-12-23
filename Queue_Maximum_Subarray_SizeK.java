import java.util.Deque;
import java.util.LinkedList;

public class Queue_Maximum_Subarray_SizeK {

    static void printMax(int arr[], int n, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int i;
        for (i = 0; i < k; i++) {
            while(!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        for (; i < n; i++) {
            System.out.println(arr[deque.peek()] + " ");
            while (!deque.isEmpty() && deque.peek() <= i-k) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        System.out.println(arr[deque.peek()]);
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int k = 3;
        printMax(arr, arr.length, k);
    }
}
