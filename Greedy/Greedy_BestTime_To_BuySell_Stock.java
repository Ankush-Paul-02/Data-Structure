package Greedy;
public class Greedy_BestTime_To_BuySell_Stock {

    public static int maxProfit(int prices[] ,int n) {
        int buy = prices[0], max_profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (buy > prices[i]) {
                buy = prices[i];
            } else if (prices[i]-buy > max_profit) {
                max_profit = prices[i]-buy;
            }
        }
        return max_profit;
    }

    public static void main(String[] args) {
        /*  Given an array prices[] of length N,representing the prices 
            of the stocks on different days,the task is to find the maximum 
            profit possible for buying and selling the stocks on ifferent 
            days using transactions where at most one transaction is allowed */

        
        int prices[] = {7, 1, 5, 6, 4};
        int n = prices.length;
        int max_profit = maxProfit(prices, n);
        System.out.println(max_profit);
    }
}
