package Stack;
import java.util.Stack;

public class Stack_Push_Bottom {

    public static void pushAtBottom(Stack<Integer> stack, int data) {
        if(stack.isEmpty()) {
          stack.push(data);
          return;  
        }
        int top = stack.pop();
        pushAtBottom(stack, data);
        stack.push(top);
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        pushAtBottom(stack, 4);

        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
