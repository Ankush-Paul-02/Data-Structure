public class BST_Sorted_Array_Balanced_BST {

    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            this.left = this.right = null;
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

    public static Node createBST(int nodes[], int start, int end) {
        if(start > end) {
            return null;
        }
        int mid = (start + end)/2;
        Node root = new Node(nodes[mid]);

        root.left = createBST(nodes, start, mid-1);
        root.right = createBST(nodes, mid+1, end);
        return root;
    }

    public static void main(String[] args) {
        int nodes[] = {3, 5, 6, 8, 10, 11, 12};
        /*
         *         8
         *       /   \
         *      5     11
         *     / \    / \
         *    3   6  10 12
         */
        Node root = createBST(nodes, 0, nodes.length-1);
        preOrder(root);
    }
}
