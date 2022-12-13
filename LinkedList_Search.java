public class LinkedList_Search {

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

    // Search Iterative
    public int interativeSearch(int key) {  // O(n)
        Node temp = head;
        int i = 0;
        while(temp != null) {
            if(temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    // Search Recursive
    public int recursiveSearch(int key) {   
        return healper(head, key);
    }
    public int healper(Node head, int key) {    // O(n)
        if(head == null) {
            return -1;
        }
        if(head.data == key) {
            return 0;
        }
        int index = healper(head.next, key);
        if(index == -1) {
            return -1;
        }
        return index+1;
    }

    public static void main(String[] args) {
        LinkedList_Search ll = new LinkedList_Search();
        ll.addFirst(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);

        System.out.println(ll.interativeSearch(3));
        System.out.println(ll.interativeSearch(10));

        System.out.println(ll.recursiveSearch(2));
    }
}
