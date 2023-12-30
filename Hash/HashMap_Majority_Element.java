package Hash;
import java.util.HashMap;

public class HashMap_Majority_Element { // O(n)
    public static void main(String[] args) {
        /*
         * Given an integer array of size n, find all elements that 
         * appear more than n/3 times.
         */

        int num[] = {1, 3, 2, 5, 1, 3, 1, 5, 1}; 
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < num.length; i++) {
            map.put(num[i], map.getOrDefault(num[i], 0)+1);
        }

        for (Integer key : map.keySet()) {
            if(map.get(key) > num.length/3) {
                System.out.println(key);
            }
        }
    }
}
