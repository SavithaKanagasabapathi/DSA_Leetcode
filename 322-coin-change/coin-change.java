class Solution {
    //TC-O(amount.coin) and SC-O(amount)
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];//including 0
        Arrays.fill(dp, amount + 1);//our INFINITY is amount+1
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                    //1 of coin+dp[amt-coin]=1+dp[i-coin], so i>=coin
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
        //coins-[2], amt-3
        //dp[0]=0, dp[1]=INF, dp[2]=1, dp[3]=1+INF, so -1
    }
}