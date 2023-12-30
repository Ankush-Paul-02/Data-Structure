package Heap;
import java.util.Comparator;
import java.util.PriorityQueue;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class NodeComparator implements Comparator<Node> {
    public int compare(Node node1, Node node2) {
        if(node1.data > node2.data) {
            return 1;
        } else if(node1.data < node2.data) {
            return -1;
        }
        return 0;
    }
}

public class Heap_Priority_Queue_Merge_K_Sorted_LinkedList {

    static Node mergeKList(Node arr[], int k) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(new NodeComparator());

        Node head = new Node(0);
        Node last = head;

        for (int i = 0; i < k; i++) {
            if(arr[i] != null) {
                priorityQueue.add(arr[i]);
            }
        }

        if(priorityQueue.isEmpty()) {
            return null;
        }

        while (!priorityQueue.isEmpty()) {
            Node curr = priorityQueue.poll();
            last.next = curr;
            last = last.next;
            if(curr.next != null) {
                priorityQueue.add(curr.next);
            }
        }
        return head.next;
    }

    public static void printList(Node node) {
        while(node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        int n = 3;

        Node []a = new Node[n];
        Node head1 = new Node(1);
        a[0] = head1;
        head1.next = new Node(3);
        head1.next.next = new Node(5);
        head1.next.next.next = new Node(7);

        Node head2 = new Node(2);
        a[1] = head2;
        head2.next = new Node(4);
        head2.next.next = new Node(6);
        head2.next.next.next = new Node(8);

        Node head3 = new Node(0);
        a[2] = head3;
        head3.next = new Node(9);
        head3.next.next = new Node(10);
        head3.next.next.next = new Node(11);

        Node res = mergeKList(a, n);

        if(res != null) {
            printList(res);
        }
        System.out.println();
    }
}
