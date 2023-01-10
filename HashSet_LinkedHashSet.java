import java.util.*;

public class HashSet_LinkedHashSet {
    public static void main(String[] args) {
        LinkedHashSet<String> set = new LinkedHashSet<>();  // order same

        set.add("India");
        set.add("Nepal");
        set.add("Japan");

        System.out.println(set);
    }
}
