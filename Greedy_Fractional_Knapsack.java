import java.util.Arrays;
import java.util.Comparator;

public class Greedy_Fractional_Knapsack {
    public static void main(String[] args) {
        /*
         * Given the weights and values of N items, put these items in 
         * a knapsack of capacity W to get the maximum total value
         * in the knapsack.
         */

        int value[] = {60, 100, 120};
        int weight[] = {10, 20, 30};
        int totalWeight = 50;

        double ratio[][] = new double[value.length][2];
        // 0th col => index; 1st col => ratio

        for (int i = 0; i < value.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = value[i]/(double)weight[i];
        }

        // assending order
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int capacity = totalWeight;
        int result = 0;

        for (int i = ratio.length-1; i >= 0; i--) {
            int index = (int)ratio[i][0];
            if(capacity >= weight[index]) { // include full item
                result += value[index];
                capacity -= weight[index];
            } else {
                // include fractional item
                result += (ratio[i][1] * capacity);
                capacity = 0;
                break;
            }
        }

        System.out.println(result);
    }
}
