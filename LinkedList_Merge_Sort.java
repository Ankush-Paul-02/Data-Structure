import java.nio.file.FileStore;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

public class LinkedList_Merge_Sort {

    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    // Add first
    public void addFirst(int data) {    // O(1)
        // create new node
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }
        // new node next = head
        newNode.next = head;
        // head = new node
        head = newNode;
    }

    // Add last
    public void addLast(int data) {     // O(1)
        // create new node
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    // Print LinkedList
    public void printList() {   // O(n)
        if(head == null) {
            System.out.println("Empty LinkedList");
            return;
        }
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    private Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private Node merge(Node head1, Node head2) {
        Node mergeLL = new Node(-1);
        Node temp = mergeLL;

        while(head1 != null && head2 != null) {
            if(head1.data < head2.data) {
               temp.next = head1; 
               head1 = head1.next;
               temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while(head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while(head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergeLL.next;
    }

    public Node mergerSort(Node head) {
        // base case
        if(head == null || head.next == null) {
            return head;
        }

        // Find mid
        Node mid = getMid(head);

        // left & right half
        Node rightHalf = mid.next;
        mid.next = null;
        Node newLeft = mergerSort(head);
        Node newRight = mergerSort(rightHalf);

        // merge
        return merge(newLeft, newRight);
    }
    public static void main(String[] args) {
        LinkedList_Merge_Sort ll = new LinkedList_Merge_Sort();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);

        ll.printList();

        ll.head = ll.mergerSort(ll.head);
        ll.printList();
    }
}
