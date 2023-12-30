public class BST_Mirror {
    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static Node createMirror(Node root) {    // O(n)
        if (root == null) {
            return null;
        }
        Node leftSubTreeMirror = createMirror(root.left);
        Node rightSubTreeMirror = createMirror(root.right);

        root.left = rightSubTreeMirror;
        root.right = leftSubTreeMirror;

        return root;
    }

    public static void preOrder(Node root) {
        if(root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(10);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(11);

        preOrder(root);
        System.out.println();
        createMirror(root);
        preOrder(root);
    }
}
