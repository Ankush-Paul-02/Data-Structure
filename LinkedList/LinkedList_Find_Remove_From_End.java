package LinkedList;
public class LinkedList_Find_Remove_From_End {

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
    
    public void deleteNthFromEnd(int n) {   // O(n)
        if(n == size) {
            head = head.next;   // remove first
        }
        // size-n
        int i = 1;
        int indexToFind = size-n;
        Node prev = head;
        while(i < indexToFind) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }

    public static void main(String[] args) {
        LinkedList_Find_Remove_From_End ll = new LinkedList_Find_Remove_From_End();
        ll.addFirst(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);

        ll.printList();
        ll.deleteNthFromEnd(3);
        ll.printList();
    }
}
