public class LinkedList_Swap_Nodes {

    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    Node head;

    public void push(int new_data) {
        Node newNode = new Node(new_data);
        newNode.next = head;
        head = newNode;
    }

    public void print() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + "\t");
            temp = temp.next;
        }
        System.out.println();
    }

    public void swapNodes(int x, int y) {
        if(x == y) {
            return;
        }
        Node prevX = null, currX = head;
        while(currX != null && currX.data != x) {
            prevX = currX;
            currX = currX.next;
        }

        Node prevY = null, currY = head;
        while(currY != null && currY.data != y) {
            prevY = currY;
            currY = currY.next;
        }

        if(currX == null || currY == null) {
            return;
        }

        if(prevX != null) {
            prevX.next = currY;
        } else {
            head = currY;
        }

        if(prevY != null) {
            prevY.next = currX;
        } else {
            head = currX;
        } 
        
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
    }


    public static void main(String[] args) {
        LinkedList_Swap_Nodes ll = new LinkedList_Swap_Nodes();
        ll.push(7);
        ll.push(6);
        ll.push(5);
        ll.push(4);
        ll.push(3);
        ll.push(2);
        ll.push(1);

        ll.print();

        ll.swapNodes(3, 5);

        ll.print();
    }
}
