class Solution {
    //TC-O(N) and SC-O(1)
    //greedily get everyday profits, if next day is profit, meaning buy, (sell and buy in same day)
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}