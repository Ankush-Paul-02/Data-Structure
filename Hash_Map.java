import java.util.*;

public class Hash_Map {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        // Insert   -O(1)
        map.put("India", 100);
        map.put("China", 150);
        map.put("US", 50);

        System.out.println(map);

        // Get   -O(1)
        System.out.println(map.get("India"));

        // ContainsKey - O(1)
        System.out.println(map.containsKey("India"));

        // remove -O(1)
        map.remove("China");
        System.out.println(map);

        // size
        System.out.println(map.size());

        // isEmpty
        System.out.println(map.isEmpty());

        map.clear();
        System.out.println(map);

        map.put("India", 100);
        map.put("China", 150);
        map.put("US", 50);
        map.put("Indonesia", 6);
        map.put("Japan", 80);

        // Iterate
        Set<String> keys = map.keySet();
        System.out.println(keys);

        for (String key : keys) {
            System.out.println("key : " + key + ", value : " + map.get(key));
        }
    }
}
