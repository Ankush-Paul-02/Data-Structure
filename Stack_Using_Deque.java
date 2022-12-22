import java.util.*;

public class Stack_Using_Deque {

    static class Stack {
        Deque<Integer> deque = new LinkedList<>();

        public void push(int data) {
            deque.addLast(data);
        }

        public int pop() {
            return deque.removeLast();
        }

        public int peek() {
            return deque.getLast();
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("peek: " + stack.peek());
        
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
