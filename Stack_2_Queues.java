import java.util.*;

public class Stack_2_Queues {

    static class Stack {
        static Queue<Integer> queue1 = new LinkedList<>();
        static Queue<Integer> queue2 = new LinkedList<>();

        public static boolean isEmpty() {
            return queue1.isEmpty() && queue2.isEmpty();
        }

        // push
        public static void push(int data) {
            if(!queue1.isEmpty()) {
                queue1.add(data);
            } else {
                queue2.add(data);
            }
        }

        // pop
        public static int pop() {
            if (isEmpty()) {
                System.out.println("Empty stack");
                return -1;
            }
            int top = -1;

            if(!queue1.isEmpty()) {
                while (!queue1.isEmpty()) {
                    top = queue1.remove();
                    if(queue1.isEmpty()) {
                        break;
                    }
                    queue2.add(top);
                }
            } else {
                while (!queue2.isEmpty()) {
                    top = queue2.remove();
                    if(queue2.isEmpty()) {
                        break;
                    }
                    queue1.add(top);
                }
            }
            return top;
        }

        // peek
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Empty stack");
                return -1;
            }
            int top = -1;

            if(!queue1.isEmpty()) {
                while (!queue1.isEmpty()) {
                    top = queue1.remove();
                    queue2.add(top);
                }
            } else {
                while (!queue2.isEmpty()) {
                    top = queue2.remove();
                    queue1.add(top);
                }
            }
            return top;
        }
    }
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        while (!stack.isEmpty()) {
            System.out.println(stack.peek());
            stack.pop();
        }
    }
}
