package LinkedList;
public class LinkedList_Even_Odd {

    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    Node head;

    public void print() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + "\t");
            temp = temp.next;
        }
        System.out.println();
    }

    public void push(int new_data) {
        Node newNode = new Node(new_data);
        newNode.next = head;
        head = newNode;
    }

    void segregateEvenOdd() {
        Node end = head;
        Node prev = null;
        Node curr = head;

        while(end.next != null) {
            end = end.next;
        }

        Node new_end = end;

        while(curr.data % 2 != 0 && curr != end) {
            new_end.next = curr;
            curr = curr.next;
            new_end.next.next = null;
            new_end = new_end.next;
        }

        if(curr.data % 2 == 0) {
            head = curr;
            while(curr != end) {
                if(curr.data % 2 == 0) {
                    prev = curr;
                    curr = curr.next;
                } else {
                    prev.next = curr.next;
                    curr.next = null;
                    new_end.next = curr;
                    new_end = curr;
                    curr = prev.next;
                }
            }
        } else {
            prev = curr;
        }

        if(new_end != end && end.data % 2 != 0) {
            prev.next = end.next;
            end.next = null;
            new_end.next = end;
        }
    }

    public static void main(String[] args) {
        LinkedList_Even_Odd ll = new LinkedList_Even_Odd();
        ll.push(6);
        ll.push(1);
        ll.push(4);
        ll.push(5);
        ll.push(10);
        ll.push(12);
        ll.push(8);

        ll.print();

        ll.segregateEvenOdd();

        ll.print();
    }
}
