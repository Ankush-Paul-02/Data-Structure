package Queue;
import java.util.LinkedList;
import java.util.Queue;


public class Queue_First_NonRep_Char {

    public static void printNonRepeatingElements(String str) {  // O(n)
        Queue<Character> queue = new LinkedList<>();
        int freq[] = new int[26];

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            queue.add(ch);
            freq[ch - 'a']++;

            while(!queue.isEmpty() && freq[queue.peek() - 'a'] > 1) {
                queue.remove();
            }

            if(queue.isEmpty()) {
                System.out.println("-1");
            } else {
                System.out.println(queue.peek());
            }
        }
    }
    public static void main(String[] args) {
        /*
         *      String: aabccxb
         *      a -> a
         *      aa -> -1
         *      aab -> b
         *      aabc -> b
         *      aabcc -> b
         *      aabccx -> b
         *      aabccxb -> x
         *      ans: a -1 b b b b x
         */ 
        String str = "aabccxb";
        printNonRepeatingElements(str);
    }
}
