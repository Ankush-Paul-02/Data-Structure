import java.util.*;

public class Stack_Max_Area_Histogram {

    public static void maxArea(int heights[]) { // O(n)
        int maxArea = 0;
        int n = heights.length;

        int nextSmallerLeft[] = new int[n];
        int nextSmallerRight[] = new int[n];

        // next smaller right
        Stack<Integer> stack = new Stack<>();
        for (int i = n-1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                nextSmallerRight[i] = n;
            } else {
                nextSmallerRight[i] = stack.peek();
            }
            stack.push(i);
        }

        // next smaller left
        stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                nextSmallerLeft[i] = n;
            } else {
                nextSmallerLeft[i] = stack.peek();
            }
            stack.push(i);
        }

        // current area: width = j-i-1 = nsr[i]-nsr[j]-1
        for (int i = 0; i < n; i++) {
            int height = heights[i];
            int width = nextSmallerRight[i]-nextSmallerLeft[i]-1;
            int currArea = height*width;
            maxArea = Math.max(maxArea, currArea);
        }
        System.out.println(maxArea);
    }

    public static void main(String[] args) {
        int heights[] = {2, 1, 5, 6, 2, 3};
        maxArea(heights);
    }
}
