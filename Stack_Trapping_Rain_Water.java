import java.util.*;;
public class Stack_Trapping_Rain_Water {

    public static int maxWater(int heights[]) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && (heights[stack.peek()] < heights[i])) {
                int pop_height = heights[stack.peek()];
                stack.pop();
                if(stack.isEmpty()) {
                    break;
                }
                int distance = i - stack.peek() - 1;
                int min_height = Math.min(heights[stack.peek()], heights[i]) - pop_height;
                ans += distance*min_height;
            }
            stack.push(i);
        }
        return ans;
    }
    public static void main(String[] args) {
        int heights[] = {7, 0, 4, 2, 5, 0, 6, 4, 0, 5};
        System.out.println(maxWater(heights));
    }
}
