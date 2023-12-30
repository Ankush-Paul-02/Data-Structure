package Stack;
import java.util.Stack;

public class Stack_Palindrome_LinkedList {

    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static boolean isPalindrome(Node head) { // O(n)
        Node temp = head;
        boolean isPalin = true;
        Stack<Integer> stack = new Stack<>();

        while(temp != null) {
            stack.push(temp.data);
            temp = temp.next;
        }

        while(head != null) {
            if(head.data != stack.pop()) {
                isPalin = false;
                break;
            }
            head = head.next;
        }
        return isPalin;
    }
    public static void main(String[] args) {
        
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(2);
        Node five = new Node(1);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        System.out.println(isPalindrome(one));
    }
}
