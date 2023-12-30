import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Binary_Tree_Bottom_View {

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

    static class Info {
        Node node;
        int horizontalDistance;
        Info(Node node, int horizontalDistance) {
            this.horizontalDistance = horizontalDistance;
            this.node = node;
        }
    }

    public static void bottomView(Node root) {
        Queue<Info> queue = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        int max = 0, min = 0;
        queue.add(new Info(root, 0));
        queue.add(null);

        while (!queue.isEmpty()) {
            Info currInfo = queue.remove();
            if(currInfo == null) {
                if(queue.isEmpty()) {
                    break;
                } else {
                    queue.add(null);
                }
            } else {
                if(!map.containsKey(currInfo.horizontalDistance)) {
                    map.put(currInfo.horizontalDistance, currInfo.node);
                } else {
                    map.put(currInfo.horizontalDistance, currInfo.node);
                }

                if(currInfo.node.left != null) {
                    queue.add(new Info(currInfo.node.left, currInfo.horizontalDistance-1));
                    min = Math.min(min, currInfo.horizontalDistance-1);
                }
                if(currInfo.node.right != null) {
                    queue.add(new Info(currInfo.node.right, currInfo.horizontalDistance+1));
                    max = Math.max(max, currInfo.horizontalDistance+1);
                }
            }
        }
        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        bottomView(root);
    }
}
