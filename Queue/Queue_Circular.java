package Queue;
public class Queue_Circular {

    static class Queue {
        static int arr[];
        static int size;
        static int rear;
        static int front;

        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        public static boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        public static boolean isFull() {
            return (rear+1)%size == front;
        }

        // add
        public static void enque(int data) {    // O(1)
            if (isFull()) {
                System.out.println("Queue is full");
                return;
            }
            // add first element
            if(front == -1) {
                front = 0;
            }
            rear = (rear+1)%size;
            arr[rear] = data;
        }

        // remove
        public static int dequeue() {   // O(1)
            if(isEmpty()) {
                System.out.println("Empty queue");
                return -1;
            }
            int res = arr[front];
            // last element delete
            if(rear == front) {
                rear = front = -1;
            } else {
                front = (front+1)%size;
            }
            return res;
        }

        // peek
        public static int peek() {
            if(isEmpty()) {
                System.out.println("Empty queue");
                return -1;
            }
            return arr[front];
        }
    }
    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.enque(1);
        queue.enque(2);
        queue.enque(3);
        queue.enque(4);
        queue.enque(5);

        System.out.println("deleted element: " + queue.dequeue());
        queue.enque(6);

        while (!queue.isEmpty()) {
            System.out.println(queue.peek());
            queue.dequeue();
        }
        System.out.println();
    }
}
