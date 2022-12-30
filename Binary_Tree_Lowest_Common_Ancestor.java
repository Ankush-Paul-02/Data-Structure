import java.util.ArrayList;

public class Binary_Tree_Lowest_Common_Ancestor {

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

    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        if(root == null) {
            return false;
        }
        path.add(root);

        if(root.data == n) {
            return true;
        }
        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        if(foundLeft || foundRight) {
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }

    public static Node lca(Node root, int a, int b) {   // O(n)
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, a, path1);
        getPath(root, b, path2);

        // last common ancestor
        int i = 0;
        for (; i < path1.size() && i < path2.size(); i++) {
            if(path1.get(i) != path2.get(i)) {
                break;
            }
        }

        // last equal node => i-1 th
        Node lca = path1.get(i-1);
        return lca;
    }

    public static Node lca2(Node root, int a, int b) {  // O(n)
        
        if(root == null || root.data == a || root.data == b) {
            return root;
        }
        Node leftLca = lca2(root.left, a, b);
        Node rightLca = lca2(root.right, a, b);

        // leftLca = val rightLc = null
        if(rightLca == null) {
            return leftLca;
        }
        if(leftLca == null) {
            return rightLca;
        }

        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(lca(root, 4, 7).data);
        System.out.println(lca2(root, 4, 7).data);
    }
}
