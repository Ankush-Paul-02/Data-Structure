import java.util.*;

public class Queue_Reverse_First_K_Elements {

    public static void reverse(Deque<Integer> deque, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            queue.add(deque.removeFirst());
        }

        while (!queue.isEmpty()) {
            deque.addFirst(queue.remove());
        }
    }
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();

        deque.add(10);
        deque.add(20);
        deque.add(30);
        deque.add(40);
        deque.add(50);
        deque.add(60);
        deque.add(70);
        deque.add(80);
        deque.add(90);
        deque.add(100);

        reverse(deque, 5);
        System.out.println(deque);
    }
}
