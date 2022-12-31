public class Binary_Tree_Transform_Sum_Tree {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void preOrder(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static int transFormTree(Node root) {    // O(n)
        if(root == null) {
            return 0;
        }
        int leftChild = transFormTree(root.left);
        int rightChild = transFormTree(root.right);

        int val = root.data;

        int newLeftData = root.left == null ? 0 : root.left.data;
        int newRightData = root.right == null ? 0 : root.right.data;

        root.data = newLeftData + leftChild + newRightData + rightChild;
        return val;
    }
    
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        transFormTree(root);
        preOrder(root);

    }
}
