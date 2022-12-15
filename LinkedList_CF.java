import java.util.LinkedList;

public class LinkedList_CF {
    public static void main(String[] args) {
        // Create
        LinkedList<Integer> ll = new LinkedList<>();
        // Add
        ll.addLast(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addFirst(0);
        // 0->1->2->3->null
        System.out.println(ll);

        ll.removeLast();
        ll.removeFirst();
        // 1->2->null
        System.out.println(ll);
    }
}
