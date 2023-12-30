class BST {

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

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        }

        if(root.data > data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }

    public static void inOrder(Node root) {
        if(root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static boolean search(Node root, int key) {  // O(h)
        if(root == null) {
            return false;
        }

        if(root.data == key) {
            return true;
        }
        if(root.data  > key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    public static Node delete(Node root, int data) {
        if(root.data < data) {
            root.right = delete(root.right, data);
        } else if(root.data > data) {
            root.left = delete(root.left, data);
        } else {
            // case 1 -> leaf Node
            if(root.left == null &&  root.right == null) {
                return null;
            }

            // case 2 -> single child
            if(root.left == null) {
                return root.right;
            } else if(root.right == null) {
                return root.left;
            }

            // case 3 -> both children
            Node IS = findInOrderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }

    public static Node findInOrderSuccessor(Node root) {
        while(root.left != null) {
            root = root.left;
        }
        return root;
    }

    // Print in range
    public static void printInRange(Node root, int k1, int k2) {
        if(root == null) {
            return;
        }
        if(root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);    
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        } else if(root.data < k1) {
            printInRange(root.left, k1, k2);
        } else {
            printInRange(root.right, k1, k2);
        }
    }

    public static void main(String[] args) {
        int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;
        
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        inOrder(root);
        System.out.println();

        if(search(root, 6)) {
            System.out.println("Found");
        } else {
            System.out.println("Not found");
        }

        root = delete(root, 1);
        System.out.println();
        inOrder(root);

        System.out.println();

        printInRange(root, 5, 12);

    }
}