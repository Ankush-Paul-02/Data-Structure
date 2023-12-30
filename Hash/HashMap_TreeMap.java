package Hash;
import java.util.TreeMap;

public class HashMap_TreeMap {  // Implemented by Red Black Tree
    public static void main(String[] args) {
        TreeMap<String, Integer> map = new TreeMap<>(); // keys are sorted
        
        map.put("Japan", 80);
        map.put("India", 100);
        map.put("Nepal", 50);

        System.out.println(map);
    }
}
