import java.util.*;

public class HashMap_LinkedHashMap {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("India", 100);
        map.put("Japan", 80);
        map.put("Nepal", 50);

        System.out.println(map);
    }
}
