package Greedy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Greedy_Indian_Coin {
    public static void main(String[] args) {
        /*
         * We are given an infinite supply of denominations
         * [1, 2, 5, 10, 20, 50, 100, 500, 2000]. Find mi no, of
         * coins/notes to make change for a value V.
         * V = 121
         * ans = 3(100+20+1)
         * V = 590
         * ans = 4(500+50+20+20)
         */

        Integer coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 2000};
        Arrays.sort(coins, Comparator.reverseOrder());
        int amount = 1059;
        int count = 0;
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < coins.length; i++) {
            if(coins[i] <= amount) {
                while(coins[i] <= amount) {
                    result.add(coins[i]);
                    count++;
                    amount = amount-coins[i];
                }
            }
        }
        System.out.println("Total minimum coin used : " + count);
        System.out.println(result);
    }
}
