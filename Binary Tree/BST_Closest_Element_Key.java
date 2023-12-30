public class BST_Closest_Element_Key {

    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    static int min_diff, min_diff_key;

    public static void closestElementUtil(Node node, int key) {
        if(node == null) {
            return;
        }
        if(node.data == key) {
            min_diff_key = key;
            return;
        }

        if(min_diff > Math.abs(node.data - key)) {
            min_diff = Math.abs(node.data - key);
            min_diff_key = node.data;
        }

        if(key < node.data) {
            closestElementUtil(node.left, key);
        } else {
            closestElementUtil(node.right, key);
        }
    }

    public static int closestElement(Node root, int key) {
        min_diff = Integer.MAX_VALUE;
        min_diff_key = -1;
        closestElementUtil(root, key);
        return min_diff_key;
    }

    public static void main(String[] args) {

        /*
         *  We have a binary tree and a target node K. The task is to 
         *  find the node with minimum absolute distance with given target
         *  value K
         */

        Node root = new Node(9);
        root.left = new Node(4);
        root.right = new Node(17);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.left.right.left = new Node(5);
        root.left.right.right = new Node(7);
        root.right.right = new Node(22);
        root.right.right.left = new Node(20);
        int key = 18;

        System.out.println(closestElement(root, key));

    }
}
