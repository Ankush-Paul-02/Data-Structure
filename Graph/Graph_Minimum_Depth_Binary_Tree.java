package Graph;
import java.util.LinkedList;
import java.util.Queue;


public class Graph_Minimum_Depth_Binary_Tree {

    static class Node {
        int data;
        Node left, right;
    }

    static class qItem {
        Node node;
        int depth;

        public qItem(Node node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    static Node newNode(int data) {
        Node temp = new Node();
        temp.data = data;
        temp.left = temp.right = null;
        return temp;
    }

    static int minimumDepth(Node root) {    // O(n)
        if(root == null) {
            return 0;
        }
        Queue<qItem> queue = new LinkedList<>();
        qItem qi = new qItem(root, 1);
        queue.add(qi);

        while(!queue.isEmpty()) {
            qi = queue.peek();
            queue.remove();
            Node node = qi.node;
            int depth = qi.depth;

            if(node.left == null && node.right == null) {
                return depth;
            }
            if(node.left != null) {
                qi.node = node.left;
                qi.depth = depth+1;
                queue.add(qi);
            }
            if(node.right != null) {
                qi.node = node.right;
                qi.depth = depth+1;
                queue.add(qi);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        /*
         *  We have a binary tree, find its minimum depth. The minimum
         *  depth is the number of nodes along the shortest path from 
         *  the root node down to the nearest leaf node.
         */

        Node root = newNode(1);
        root.left = newNode(2);
        root.right = newNode(3);
        root.left.left = newNode(4);
        root.left.right = newNode(5);

        System.out.println(minimumDepth(root));
    }
}
