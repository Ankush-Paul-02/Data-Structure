package Stack;
import java.util.Stack;

public class Stack_Decode_String {

    public static String stringDecoder(String str) {
        String temp = "";
        String res = "";
        Stack<Character> stringStack = new Stack<>();
        Stack<Integer> integerStack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            int count = 0;
            if(Character.isDigit(str.charAt(i))) {
                while(Character.isDigit(str.charAt(i))) {
                    count = count*10 + str.charAt(i) - '0';
                    i++;
                }
                i--;
                integerStack.push(count);
            }
            else if(str.charAt(i) == ']') {
                temp = "";
                count = 0;
                if(!integerStack.isEmpty()) {
                    count = integerStack.peek();
                    integerStack.pop();
                }
                while (!stringStack.isEmpty() && stringStack.peek() != '[') {
                    temp = stringStack.peek() + temp;
                    stringStack.pop();
                }
                if(!stringStack.isEmpty() && stringStack.peek() == '[') {
                    stringStack.pop();
                }
                for (int j = 0; j < count; j++) {
                    res = res + temp;
                }
                for (int j = 0; j < res.toString().length(); j++) {
                    stringStack.push(res.toString().charAt(j));
                }
                res = "";
            }
            else if (str.charAt(i) == '[') {
                if(Character.isDigit(str.charAt(i-1))) {
                    stringStack.push(str.charAt(i));
                } else {
                    stringStack.push(str.charAt(i));
                    integerStack.push(1);
                }
            }
            else {
                stringStack.push(str.charAt(i));
            }
        }
        while(!stringStack.isEmpty()) {
            res = stringStack.peek() + res;
            stringStack.pop();
        }
        return res.toString();
    }
    public static void main(String[] args) {
        String str = "2[cv]";
        System.out.println(stringDecoder(str));
    }
}
