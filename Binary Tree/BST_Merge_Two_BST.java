import java.util.*;

public class BST_Merge_Two_BST {

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

    public static void getInOrder(Node root, ArrayList<Integer> list) {
        if(root == null) {
            return;
        }
        getInOrder(root.left, list);
        list.add(root.data);
        getInOrder(root.right, list);
    }

    public static Node mergeBSTs(Node root1, Node root2) {
        // step 1 : Get InOrder of BST
        ArrayList<Integer> list1 = new ArrayList<>();
        getInOrder(root1, list1);
        ArrayList<Integer> list2 = new ArrayList<>();
        getInOrder(root2, list2);

        // step 2: Merge
        ArrayList<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        while(i < list1.size() && j < list2.size()) {
            if(list1.get(i) <= list2.get(j)) {
                res.add(list1.get(i));
                i++;
            } else {
                res.add(list2.get(j));
                j++;
            }
        }
        while(i < list1.size()) {
            res.add(list1.get(i));
            i++;
        }
        while(j < list2.size()) {
            res.add(list2.get(j));
            j++;
        }

        // step 3: sorted Al --> Balanced Binary Tree
        return createBST(res, 0, res.size()-1);
    }

    public static Node createBST(ArrayList<Integer> list, int start, int end) {
        if(start > end) {
            return null;
        }
        int mid = (start+end)/2;
        Node root = new Node(list.get(mid));
        root.left = createBST(list, start, mid-1);
        root.right = createBST(list, mid+1, end);
        return root;
    }

    public static void main(String[] args) {
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        Node root = mergeBSTs(root1, root2);
        preOrder(root);
    }
}
