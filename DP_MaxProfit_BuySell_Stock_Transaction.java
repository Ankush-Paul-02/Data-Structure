public class DP_MaxProfit_BuySell_Stock_Transaction {

    static int maxProfit(int price[], int res[], int n, int fee) {  //! O(n^2)
        int profit, l, r, difference_day = 1, sum = 0;
        res[0] = 0;
        res[1] = difference_day;

        for (int i = 1; i < n; i++) {
            l = 0;
            r = difference_day;
            sum = 0;

            for (int j = n-1; j >= i; j--) {
                profit = (price[r]-price[l]) - fee;
                if(profit > 0) {
                    sum += profit;
                }
                l++;
                r++;
            }
            if(res[0] < sum) {
                res[0] = sum;
                res[1] = difference_day;
            }
            difference_day++;
        }
        return 0;
    }

    public static void main(String[] args) {
        /*
         * We have an array of positive integers containing the price of
         * stocks and transaction fee, the task is to find the maximum profit 
         * and the difference of days on which you are getting the maximum profit.
         */

        int price[] = {6, 1, 7, 2, 8, 4};
        int transactionFee = 2; 

        int n = price.length;
        int res[] = new int[2];
        maxProfit(price, res, n, transactionFee);
        System.out.println(res[0] + "," + res[1]);

    }
}
