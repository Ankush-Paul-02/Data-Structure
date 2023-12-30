import java.util.HashMap;

class Binary_Tree_Duplicate_SubTrees {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    static HashMap<String, Integer> map = new HashMap<>();

    static String inOrder(Node node) {
        if(node == null) {
            return "";
        }
        String str = "(";
        str += inOrder(node.left);
        str += Integer.toString(node.data);
        str += inOrder(node.right);
        str += ")";

        if(map.get(str) != null && map.get(str) == 1) {
            System.out.print(node.data + " ");
        }
        if(map.containsKey(str)) {
            map.put(str, map.get(str)+1);
        } else {
            map.put(str, 1);
        }
        return str;
    }

    static void printAllDuplicates(Node root) {
        map = new HashMap<>();
        inOrder(root);
    }

    public static void main(String[] args) {
        /*
         * We have a binary tree, find all duplicate subtrees. For each
         * duplicate subtrees, we only need to return the root node of any
         * one of them. Two trees are duplicate if they have the same structure
         * with the same node values.
         */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(2);
        root.right.left.left = new Node(4);
        root.right.right = new Node(4);

        printAllDuplicates(root);
    }
}