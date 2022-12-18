import java.util.*;

public class Stack_Reverse_Stack {

    public static void reverseString(String str) {
        Stack<Character> stack = new Stack<>();
        int index = 0;
        while(index < str.length()) {
            stack.push(str.charAt(index));
            index++;
        }
        StringBuilder sb = new StringBuilder("");
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        String str = "luap hsukna";
        reverseString(str);
    }
}
