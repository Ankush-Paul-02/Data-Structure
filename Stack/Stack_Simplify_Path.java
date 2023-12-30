package Stack;
import java.util.Stack;

public class Stack_Simplify_Path {

    public static String simplify(String str) { // O(n)
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder("");
        sb.append("/");

        int len = str.length();

        for (int i = 0; i < len; i++) {
            String directory = "";
            while (i < len && str.charAt(i) == '/') {
                i++;
            }
            while (i < len && str.charAt(i) != '/') {
                directory += str.charAt(i);
                i++;
            }

            if(directory.equals("..") == true) {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            } else if(directory.equals(".") == true) {
                continue;
            } else if(directory.length() != 0) {
                stack.push(directory);
            }
        }

        Stack<String> stack2 = new Stack<>();
        while(!stack.isEmpty()) {
            stack2.push(stack.pop());
        }
        while (!stack2.isEmpty()) {
            if(stack2.size() != 1) {
                sb.append(stack2.pop()+"/");
            } else {
                sb.append(stack2.pop());
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String str = new String("/a./b/../../c/");
        String res = simplify(str);
        System.out.println(res);
    }
}
