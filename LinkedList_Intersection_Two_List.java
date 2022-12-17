public class LinkedList_Intersection_Two_List {
    /*
     * In a system there are two singly linked list. By some programming error 
     * the end node of one of the linked lists got linked to the second list,
     * forming an inverted y-shaped list. write a program to get the point 
     * where two linked list merge.
     * 
     *              1
     *      4       /
     *       \      2
     *        5     /
     *        \     3
     *         \   /    
     *           6
     *           /
     *          7
     */

    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node getIntersectionNode(Node head1, Node head2) {   // O(m*n)
        while(head2 != null) {
            Node temp = head1;
            while(temp != null) {
                if(temp == head2) {
                    return head2;
                }
                temp = temp.next;
            }
            head2 = head2.next;
        } 
        return null;
    }


    public static void main(String[] args) {
        LinkedList_Intersection_Two_List ll = new LinkedList_Intersection_Two_List();
        Node head1, head2;
        head1 = new Node(1);
        head2 = new Node(4);
        
        Node newNode = new Node(2);
        head1.next = newNode;

        newNode = new Node(3);
        head1.next.next = newNode;

        newNode = new Node(6);
        head1.next.next.next = newNode;

        newNode = new Node(7);
        head1.next.next.next.next = newNode;
        newNode.next = null;

        newNode = new Node(5);
        head2.next = newNode;
        newNode.next = head1.next.next.next;

        Node intersectionPoint = ll.getIntersectionNode(head1, head2);
        if(intersectionPoint == null) {
            System.out.println("NO INTERSECTION POINT!");
        } else {
            System.out.println("INTERSECTION POINT: " + intersectionPoint.data);
        }
    }
}
