package String;
import java.util.HashMap;

public class String_Longest_SubString_Without_Rep_Char {
    public static void main(String[] args) {
        String str = "pwwkew";
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int left = 0, right = 0;
        int n = str.length();
        int maxLength = 0;

        while(right < n) {
            if(map.containsKey(str.charAt(right))) {
                left = Math.max(map.get(str.charAt(right)) + 1, left);
            }
            map.put(str.charAt(right), right);
            maxLength = Math.max(maxLength, right-left+1);
            right++;
        }
        System.out.println(maxLength);
    }
}
