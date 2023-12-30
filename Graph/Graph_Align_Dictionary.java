package Graph;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Graph_Align_Dictionary {

    public static String alienOrder(String words[]) {  //! O(v+e)
        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Integer> degree = new HashMap<>();

        String result = "";
        if(words == null || words.length == 0) return result;

        for (String string : words) {
            for (char ch : string.toCharArray()) {
                degree.put(ch, 0);
            }
        }

        for (int i = 0; i < words.length-1; i++) {
            String curr = words[i];
            String next = words[i+1];

            int min = Math.min(curr.length(), next.length());
            for (int j = 0; j < min; j++) {
                char c1 = curr.charAt(j);
                char c2 = next.charAt(j);

                if(c1 != c2) {
                    Set<Character> set = map.getOrDefault(c1, new HashSet<>());
                    if(!set.contains(c2)) {
                        set.add(c2);
                        map.put(c1, set);
                        degree.put(c2, degree.get(c2) + 1); // upgrade c2, c1 < c2
                    }
                    break;
                }
            }
        }

        LinkedList<Character> list = new LinkedList<>();
        for (char ch : degree.keySet()) {
            if(degree.get(ch) == 0) {
                list.add(ch);
            }
        }

        while(!list.isEmpty()) {
            char ch = list.poll();
            result += ch;
            if(map.containsKey(ch)) {
                for (char next : map.get(ch)) {
                    degree.put(next, degree.get(next)-1);
                    if(degree.get(next) == 0) {
                        list.offer(next);
                    }
                }
            }
        }
        return result.length() == degree.size() ? result :"";
    }

    public static void main(String[] args) {
        /*
         *  We have a sorted dictionary of an alien language having N
         *  words and k starting alphabets of standard dictionary. Find
         *  the order of characters in the alien language. Many orders  
         *  may be possible for a particular test case. Thus ypu may return 
         *  any valid order and output will be 1 if the order of string 
         *  returned by the function is correct else 0 denoting incorrect 
         *  string returned.
         */

        String dictionary[] = {"caa", "aaa", "aab"};
        System.out.println(alienOrder(dictionary));
    }
}
