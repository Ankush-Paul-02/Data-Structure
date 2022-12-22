import java.util.*;

public class Queue_Interleave_2_Halves {    // O(n) & O(n)

    public static void interLeave(Queue<Integer> queue) {
        int size = queue.size();
        Queue<Integer> firstHalf = new LinkedList<>();

        for (int i = 0; i < size/2; i++) {
            firstHalf.add(queue.remove());
        }

        while(!firstHalf.isEmpty()) {
            queue.add(firstHalf.remove());
            queue.add(queue.remove());
        }
    }
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.add(7);
        queue.add(8);
        queue.add(9);
        queue.add(10);

        interLeave(queue);

        while(!queue.isEmpty()) {
            System.out.print(queue.remove() + " ");
        }
    }
}
