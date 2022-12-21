import java.util.*;

public class Queue_JCF {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();  // ArrayDeque
        /* Queue is a interface so we can't create any object
            so which class implements Queue.. we can create that class's object */
        queue.add(1);
        queue.add(2);
        queue.add(3);

        while (!queue.isEmpty()) {
            System.out.println(queue.peek());
            queue.remove();
        }
    }
}
