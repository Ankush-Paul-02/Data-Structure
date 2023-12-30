package LinkedList;
public class LinkedList {

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

    // Add Middle
    public void addMiddle(int data, int index) {
        if(index == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
        }
        Node temp = head;
        int i = 0;
        while(i < index-1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Remove First
    public int removeFirst() {
        if(size == 0) {
            System.out.println("Empty LinkedList");
            return Integer.MIN_VALUE;
        } else if(size == 1) {
            int val = head.data;
            head = tail = null; 
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    // Remove last
    public int removeLast() {
        if(size == 0) {
            System.out.println("Empty LinkedList");
            return Integer.MIN_VALUE;
        } else if(size == 1) {
            int val = head.data;
            head = tail = null; 
            size = 0;
            return val;
        }
        Node temp = head;
        while(temp.next.next != null) {
            temp = temp.next;
        }
        int val = tail.data;
        temp.next = null;
        tail = temp;
        size--;
        return val;
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

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);
        ll.printList();

        ll.addMiddle(5, 2);
        ll.printList();

        System.out.println("Size of the linkedlist: " + size);

        ll.removeFirst();
        ll.printList();

        ll.removeLast();
        ll.printList();

        System.out.println("Size of the linkedlist: " + size);
    }
}
