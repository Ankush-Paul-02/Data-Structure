public class Queue_Array {

    static class Queue {
        static int arr[];
        static int size;
        static int rear;

        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
        }

        public static boolean isEmpty() {
            return rear == -1;
        }

        // add
        public static void enque(int data) {    // O(1)
            if (rear == size - 1) {
                System.out.println("Queue is full");
                return;
            }
            rear++;
            arr[rear] = data;
        }

        // remove
        public static int dequeue() {   // O(n)
            if(isEmpty()) {
                System.out.println("Empty queue");
                return -1;
            }
            int front = arr[0];
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i+1];
            }
            rear--;
            return front;
        }

        // peek
        public static int peek() {
            if(isEmpty()) {
                System.out.println("Empty queue");
                return -1;
            }
            return arr[0];
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.enque(1);
        queue.enque(2);
        queue.enque(3);
        queue.enque(4);
        queue.enque(5);

        while (!queue.isEmpty()) {
            System.out.println(queue.peek());
            queue.dequeue();
        }
        System.out.println();
    }
}
