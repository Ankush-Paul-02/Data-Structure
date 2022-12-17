public class LinkedList_Delete_N_Nodes_After_M_Nodes {

    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void getResultantList(Node head, int m, int n) { // O(n)
        Node curr = head, temp;
        int count = 0;
        while(curr != null) {
            for(count = 1; count < m && curr != null; count++) {
                curr = curr.next;
            }
            if(curr == null) {
                return;
            }
            temp = curr.next;
            for(count = 1; count < m && temp != null; count++) {
                temp = temp.next;
            }
            curr.next = temp;
            curr = temp;
        }
    }

    public void print(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        LinkedList_Delete_N_Nodes_After_M_Nodes ll = new LinkedList_Delete_N_Nodes_After_M_Nodes();

        Node head = new Node(1);
        
        Node newNode = new Node(2);
        head.next = newNode;

        newNode = new Node(3);
        head.next.next = newNode;

        newNode = new Node(4);
        head.next.next.next = newNode;

        newNode = new Node(5);
        head.next.next.next.next = newNode;

        newNode = new Node(6);
        head.next.next.next.next.next = newNode;

        newNode = new Node(7);
        head.next.next.next.next.next.next = newNode;

        newNode = new Node(8);
        head.next.next.next.next.next.next.next = newNode;

        ll.getResultantList(head, 3, 2);
        ll.print(head);
    }
}
