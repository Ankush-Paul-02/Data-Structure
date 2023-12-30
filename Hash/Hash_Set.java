package Hash;
import java.util.HashSet;
import java.util.Iterator;

class Hash_Set {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(2);

        System.out.println(set);

        if(set.contains(3)) {
            System.out.println("Contains 3.");
        } else {
            System.out.println("Not contains 3");
        }

        set.remove(2);
        System.out.println(set);
        System.out.println(set.isEmpty());

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {    // using iterator interface
            System.out.println(iterator.next());
        }

        for (Integer integer : set) {   // using enhanced for loop
            System.out.println(integer);
        }
    }
}