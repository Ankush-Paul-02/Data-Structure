public class BST_AVL_Tree {

    static class Node {
        int data, height;
        Node left, right;
        Node(int data) {
            this.data = data;
            this.height = 1;
            this.left = this.right = null;
        }
    }

    public static Node root;

    public static void preOrder(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static int height(Node root) {
        if(root == null) {
            return 0;
        }
        return root.height;
    }

    static int max(int a, int b) {
        return (a>b) ? a : b;
    }

    // Get Balanced Factor of a node
    public static int getBalancedFactor(Node root) {
        if (root == null) {
            return 0;
        }
        return height(root.left) - height(root.right);
    }

    // Left rotate subtree rotated with x
    public static Node leftRotate(Node x) {
        Node y = x.right;
        Node z = y.left;

        // perform rotation
        y.left = x;
        x.right = z;

        // Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        // return new root
        return y;
    }

    // right rotate subtree rotated with y
    public static Node rightRotate(Node y) {
        Node x = y.left;
        Node z = x.right;

        // perform rotation
        x.right = y;
        y.left = z;

        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        // return new root
        return x;
    }

    public static Node insert(Node root, int key) {
        if(root == null) {
            return new Node(key);
        }
        
        if(key < root.data) {
            root.left = insert(root.left, key);
        } else if (key > root.data) {
            root.right = insert(root.right, key);
        } else {
            return root;    // duplicate keys not allowed
        }

        // Update root height
        root.height = 1 + Math.max(height(root.left), height(root.right));

        // Get root's balanced factor
        int bf = getBalancedFactor(root);

        // Left Left case
        if(bf > 1 && key < root.left.data) {
            return rightRotate(root);
        }

        // Right Right case
        if(bf < -1 && key > root.right.data) {
            return leftRotate(root);
        }

        // Left Right case
        if(bf > 1 && key > root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Left case
        if(bf < -1 && key < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;    // return if AVL is balanced
    }

    public static void main(String[] args) {
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);

        preOrder(root);
    }
}
