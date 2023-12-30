package Greedy;
import java.util.Arrays;
import java.util.Comparator;

public class Greedy_Max_Length_Chain_Pair {
    public static void main(String[] args) {
        /*
         * You are given n pair of numbers. In every pair, the first
         * number is always smaller than the second number. A pair
         * (c, d) can come after pair (a, b) if b < c.
         * Find the longest chain which can be formed from a given set
         * of pairs. ~~ Activity Selection
         */ 

        int pairs[][] = {
            {5, 24},
            {39, 60},
            {5, 28},
            {27, 40},
            {50, 90}
        };

        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        int chainLength = 1;
        int chainEnd = pairs[0][1]; 

        for (int i = 1; i < pairs.length; i++) {
            if(pairs[i][0] > chainEnd) {
                chainLength++;
                chainEnd = pairs[i][1];
            }    
        }

        System.out.println("max length of chain : " + chainLength); // O(nlogn)
    }
}
