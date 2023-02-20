import java.util.*;

public class Graph_Word_Ladder {

    static int shortestChainLen(String start, String target, Set<String> dictionary) {
        if(start == target) {
            return 0;
        }
        if(!dictionary.contains(target)) {
            return 0;
        }
        int level = 0, wordLength = start.length();
        Queue<String> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()) {
            level++;
            int sizeOfQueue = queue.size();
            for (int i = 0; i < sizeOfQueue; i++) {
                char word[] = queue.peek().toCharArray();
                queue.remove();
                for (int pos = 0; pos < wordLength; pos++) {
                    char originalChar = word[pos];
                    for (char j = 'a'; j <= 'z'; j++) {
                        word[pos] = j;
                        if(String.valueOf(word).equals(target)) {
                            return level+1;
                        }
                        if(!dictionary.contains(String.valueOf(word))) {
                            continue;
                        }
                        dictionary.remove(String.valueOf(word));
                        queue.add(String.valueOf(word));
                    }
                    word[pos] = originalChar;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        /*
         *  We have a dictionary, and two words 'start' and 'target'
         *  (both of same length). Find length of the smallest chain 
         *  from start to target if it exists, such that adjacent words
         *  in the chain only differ by one character and each word in the
         *  chain is a valid  word i.e., it exists in the dictionary. It
         *  may be assumed that the 'target' word exists in the dictionary
         *  and length of all dictionary words is same.
         */

        Set<String> dictionary = new HashSet<>();
        dictionary.add("poon"); 
        dictionary.add("plee"); 
        dictionary.add("same"); 
        dictionary.add("poie"); 
        dictionary.add("plie"); 
        dictionary.add("poin"); 
        dictionary.add("plea"); 
        
        String start = "toon";
        String target = "plea";

        System.out.println("Length of the shortest chain is: " + shortestChainLen(start, target, dictionary));
    }
}
