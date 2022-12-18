import java.util.*;

public class Stack_Valid_Parenthesis {

    public static boolean isValid(String str) { // O(n)
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            
            if(ch == '(' || ch == '{' || ch == '[') {   // opening
                stack.push(ch);
            } else {    // closing
                if(stack.isEmpty()) {
                    return false;
                }
                if((stack.peek() == '(' && ch == ')') || (stack.peek() == '{' && ch == '}') || (stack.peek() == '[' && ch == ']')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        if(stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String str = "{([])([])}";
        System.out.println(isValid(str));
    }
}
