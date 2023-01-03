import java.util.*;

public class BST_To_Balanced_BST {

    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    static ArrayList<Integer> list = new ArrayList<>();

    public static void inOrder(Node root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        list.add(root.data);
        inOrder(root.right);
    }

    public static void preOrder(Node root) {
        if(root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static Node createBalanceBST(ArrayList<Integer> list, int start, int end) {
        if(start > end) {
            return null;
        }
        int mid = (start+end)/2;
        Node root = new Node(list.get(mid));

        root.left = createBalanceBST(list, start, mid-1);
        root.right = createBalanceBST(list, mid+1, end);

        return root;
    }

    public static void main(String[] args) {

        /*
         *          8
         *        /   \
         *      6      10
         *     /        \
         *    5          11
         *   /             \
         *  3               12
         */

        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);
        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);

        inOrder(root);
        Node root1 = createBalanceBST(list, 0, list.size()-1);
        preOrder(root1);

    }
}
