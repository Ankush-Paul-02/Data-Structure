public class LinkedList_Zig_Zag {
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
    
    // Find mid
    public Node findMid() {
        Node slow = head;
        Node fast = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void zigZag() {
        // Find middle
        Node mid = findMid();

        // reverese
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;
        
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;
        Node nextLeft, nextRight;
        // alternate merge
        while (left != null && right != null) {
            nextLeft = left.next;
            left.next = right;
            nextRight = right.next;
            right.next = nextLeft;

            left = nextLeft;
            right = nextRight;
        }
    }


    public static void main(String[] args) {
        LinkedList_Zig_Zag ll = new LinkedList_Zig_Zag();
        ll.addFirst(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);

        ll.printList();

        ll.zigZag();
        ll.printList();
    }
}
