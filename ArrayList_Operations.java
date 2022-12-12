import java.util.*;

public class ArrayList_Operations {

    public static void swap(ArrayList<Integer> list, int index1, int index2) {
        int temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list);
        System.out.println(list.get(2));

        // remove
        list.remove(2);
        System.out.println(list);

        // set
        list.set(2, 3);
        System.out.println(list);

        // contains
        System.out.println(list.contains(2));
        System.out.println(list.contains(22));

        // add
        list.add(3, 4);
        System.out.println(list);

        // size
        System.out.println(list.size());

        // reverse list
        for(int i = list.size()-1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();


        // Find max value
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            max = Math.max(max, list.get(i));
        }
        System.out.println(max);

        // swap
        System.out.println(list);
        swap(list, 1, 4);
        System.out.println(list);

        // sort
        Collections.sort(list);
        System.out.println(list);

        // Decending
        Collections.sort(list, Collections.reverseOrder()); // comparator
        System.out.println(list);
    }
}
