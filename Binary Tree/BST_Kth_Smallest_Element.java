public class BST_Kth_Smallest_Element {

    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    static int count = 0;

    public static Node insert(Node root, int x) {
        if(root == null) {
            return new Node(x);
        }
        if(x < root.data) {
            root.left = insert(root.left, x);
        } else if(x > root.data) {
            root.right = insert(root.right, x);
        }
        return root;
    }

    public static Node kthSmallest(Node root, int k) {
        if(root == null) {
            return null;
        }
        Node left = kthSmallest(root.left, k);
        if(left != null) {
            return left;
        }
        count++;
        if(count == k) {
            return root;
        }
        return kthSmallest(root.right, k);
    }

    public static void printKthSmallest(Node root, int k) {
        Node res = kthSmallest(root, k);
        if(res == null) {
            System.out.println("There are less than k nodes in the BST");
        } else {
            System.out.println("Kth smallest element is: " + res.data);
        }
    }

    public static void main(String[] args) {
        /*
         *  We have the root of a binary tree and K as input, find Kth 
         *  smallest element in BST.
         */
        
        Node root = null;
        int keys[] = {20, 8, 22, 4, 12, 10, 14};
        for(int x: keys) {
            root = insert(root, x);
        }
        int k = 3;
        printKthSmallest(root, k);
    }
}
