public class BST_Validate {
    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static boolean isValidBst(Node root, Node minNode, Node maxNode) {
        if(root == null) {
            return true;
        }

        if(minNode != null && root.data <= minNode.data) {
            return false;
        } else if(maxNode != null && root.data >= maxNode.data) {
            return false;
        }

        return isValidBst(root.left, minNode, root) && isValidBst(root.right, root, maxNode);
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(14);

        System.out.println(isValidBst(root, null, null));
    }
}
