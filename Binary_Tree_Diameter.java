public class Binary_Tree_Diameter {
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


    public static int height(Node root) {
        if(root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
    public static int diameter_approach2(Node root) { // O(n^2)
        if(root == null) {
            return 0;
        }
        // left diameter
        int left_diameter = diameter_approach2(root.left);
        // right diameter
        int right_diameter = diameter_approach2(root.right);
        // left height
        int left_height = height(root.left);
        // right height
        int right_height = height(root.right);

        // self diameter
        int self_diameter = left_height+right_height+1;

        return Math.max(self_diameter, Math.max(right_diameter, left_diameter));

    }


    static class Info {
        int diameter;
        int height;
        public Info(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }
    public static Info diameter_approach1(Node root) {  // O(n)
        if(root == null) {
            return new Info(0, 0);
        }
        Info left_info = diameter_approach1(root.left);
        Info right_info = diameter_approach1(root.right);

        int diameter = Math.max(Math.max(left_info.diameter, right_info.diameter), left_info.height+right_info.height+1);
        int height = Math.max(left_info.height, right_info.height) + 1;
        return new Info(diameter, height);
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(diameter_approach2(root));
        System.out.println(diameter_approach1(root).diameter);
    }
}
