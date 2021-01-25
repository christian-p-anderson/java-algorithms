package LeetCode;

public class BuyAndSell {

    /**
     * Determine the maximum profit that can be obtained by making the transactions (no limit on the number of
     * transactions done). Fr this we need to find out those sets of buying and selling prices which together lead to
     * the maximization of profit
     */


    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxprofit += prices[i] - prices[i - 1];
            }
        }
        return maxprofit;
    }


    /**
     * Time complexity O(n). Single pass
     * Space complexity O(1). Constant space needed
     */
}


