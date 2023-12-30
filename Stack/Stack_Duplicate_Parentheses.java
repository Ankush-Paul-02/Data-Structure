package Stack;
import java.util.Stack;

public class Stack_Duplicate_Parentheses {

    public static boolean isDuplicate(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // closing
            if(ch == ')') {
                int count = 0;
                while(stack.peek() != '(') {
                    stack.pop();
                    count++;
                }
                if(count < 1) {
                    return true;    // duplicate
                } else {
                    stack.pop();    // opening pair
                }
            } else {    // opening, operator
                stack.push(ch);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String str1 = "((a+b))";    // true
        // String str2 = "(a+b)";  // false
        System.out.println(isDuplicate(str1));
    }
}
