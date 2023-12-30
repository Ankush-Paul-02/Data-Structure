public class BST_Max_Sum_BST_Binary_Tree {

    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    static class Info {
        int max;
        int min;
        boolean isBST;
        int sum;
        int currMax;

        Info(int max, int min, boolean isBST, int sum, int currMax) {
            this.max = max;
            this.min = min;
            this.isBST = isBST;
            this.sum = sum;
            this.currMax = currMax;
        }
        Info(){};
    }

    static class INT {
        int a;
    }

    static Info MaxSumBSTUtil(Node root, INT maxSum) {
        if(root == null) {
            return new Info(Integer.MIN_VALUE, Integer.MAX_VALUE, true, 0, 0);
        }
        if(root.left == null && root.right == null) {
            maxSum .a = Math.max(maxSum.a, root.data);
            return new Info(root.data, root.data, true, root.data, maxSum.a);
        }

        Info L = MaxSumBSTUtil(root.left, maxSum);
        Info R = MaxSumBSTUtil(root.right, maxSum);
        Info BST=new Info();
        if (L.isBST && R.isBST && L.max < root.data &&R.min > root.data) {

            BST.max = Math.max(root.data, Math.max(L.max, R.max));
            BST.min = Math.min(root.data, Math.min(L.min, R.min));

            maxSum.a = Math.max(maxSum.a, R.sum +root.data + L.sum); 
            BST.sum = R.sum + root.data +L.sum;
            BST.currMax = maxSum.a;
            BST.isBST = true;
            return BST;
        }

        BST.isBST = false;
        BST.currMax = maxSum.a;
        BST.sum = R.sum + root.data + L.sum;
        return BST;
    }

    static int MaxSumBST(Node root) {
        INT maxsum = new INT();
        maxsum.a = Integer.MIN_VALUE;
        return MaxSumBSTUtil(root,maxsum).currMax; 
    }

    public static void main(String[] args) {
        /*
         * We have a binary tree, the task is to print the maximum
         * sum of nodes of a subtree which is also a Binary Tree
         */

        Node root = new Node(5);
        root.left = new Node(14);
        root.right = new Node(3);
        root.left.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(9);
        root.left.left.right = new Node(1);
        System.out.println(MaxSumBST(root));
    }
}
