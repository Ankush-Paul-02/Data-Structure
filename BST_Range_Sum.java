import java.util.*;
public class BST_Range_Sum {

    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    static int sum = 0;

    static int rangeSum(Node root, int low, int high) {
        if(root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(queue.isEmpty() == false) {
            Node curr = queue.peek();
            queue.remove();
            if(curr.data >= low && curr.data <= high) {
                sum += curr.data;
            }
            if(curr.left != null && curr.data > low) {
                queue.add(curr.left);
            }
            if(curr.right != null && curr.data < high) {
                queue.add(curr.right);
            }
        }
        return sum;
    }

    static Node insert(Node node, int data) {
        if(node == null) {
            return new Node(data);
        }
        if(data <= node.data) {
            node.left = insert(node.left, data);
        } else {
            node.right = insert(node.right, data);
        }
        return node;
    }

    public static void main(String[] args) {

        /*
         *  We have a Binary tree consisting of N nodes and two positive
         *  integers L and R, the tsk is to find the sum of values of all
         *  the nodes that lie in the range[L, R]
         */

        Node root = null;
        root = insert(root, 10);
        insert(root, 5);
        insert(root, 15);
        insert(root, 3);
        insert(root, 7);
        insert(root, 18);
        
        int low = 7, high = 15;
        System.out.println(rangeSum(root, low, high));
    }
}
