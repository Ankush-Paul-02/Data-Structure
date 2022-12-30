public class Binary_Tree_MinDistance_TwoNodes {

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

    public static Node lca(Node root, int a, int b) {  // O(n)
        
        if(root == null || root.data == a || root.data == b) {
            return root;
        }
        Node leftLca = lca(root.left, a, b);
        Node rightLca = lca(root.right, a, b);

        // leftLca = val rightLc = null
        if(rightLca == null) {
            return leftLca;
        }
        if(leftLca == null) {
            return rightLca;
        }

        return root;
    }

    public static int lcaDistance(Node root, int n) {
        if(root == null) {
            return -1;
        }
        if(root.data == n) {
            return 0;
        }

        int leftDist = lcaDistance(root.left, n);
        int rightDist = lcaDistance(root.right, n);

        if(leftDist == -1 && rightDist == -1) {
            return -1;
        } else if(leftDist == -1) {
            return rightDist+1;
        } else {
            return leftDist+1;
        }
    }

    public static int minimumDistance(Node root, int a, int b) {
        Node lca = lca(root, a, b);

        int dist1 = lcaDistance(lca, a);
        int dist2 = lcaDistance(lca, b);

        return dist1+dist2;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(minimumDistance(root, 4, 6));
    }
}
