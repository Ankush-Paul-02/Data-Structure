package Hash;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HashMap_Sort_By_Frequency {

    public static String sortString(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0)+1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> priorityQueue = new PriorityQueue<>((a, b)->a.getValue() == b.getValue() ? a.getKey()-b.getKey() : b.getValue()-a.getValue());

        for(Map.Entry<Character, Integer> e : map.entrySet()) {
            priorityQueue.add(e);
        }

        while (priorityQueue.size() != 0) {
            char ch = priorityQueue.poll().getKey();
            int val = map.get(ch);
            while(val != 0) {
                sb.append(ch);
                val--;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        /*
         *  Given a string s, sort it in decreasing order based on the frequency of the character.
         *  The frequency of a character is the number of times of times it appears in the string.
         *  Return the sorted string, if there are multiple answers, return any of them.
         */
        

        String str = "tree";
        System.out.println(sortString(str));
    }
}
