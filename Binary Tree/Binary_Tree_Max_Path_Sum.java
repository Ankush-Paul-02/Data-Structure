class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

class Res {
    public int val;
}

public class Binary_Tree_Max_Path_Sum {

        Node root;
        int findMaxUtil(Node node, Res res) {
            if(node == null) {
                return 0;
            }

            int left = findMaxUtil(node.left, res);
            int right = findMaxUtil(node.right, res);

            int max_single = Math.max(Math.max(left, right) + node.data, node.data);

            int max_top = Math.max(max_single, left+right+node.data);

            res.val = Math.max(res.val, max_top);
            return max_single;
        }

        int findMaxSum() {
            return findMaxSum(root);
        }

        int findMaxSum(Node node) {
            Res res = new Res();
            res.val = Integer.MIN_VALUE;
            
            findMaxUtil(node, res);
            return res.val;
        }

    public static void main(String[] args) {
        Binary_Tree_Max_Path_Sum tree = new Binary_Tree_Max_Path_Sum();
        tree.root = new Node(10);
        tree.root.left = new Node(2);
        tree.root.right = new Node(10);
        tree.root.left.left = new Node(20);
        tree.root.left.right = new Node(1);
        tree.root.right.right = new Node(-25);
        tree.root.right.right.left = new Node(3);
        tree.root.right.right.right = new Node(4);

        System.out.println("Maximum path sum is : " + tree.findMaxSum());
    }
}
