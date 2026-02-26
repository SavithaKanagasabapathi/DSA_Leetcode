class Solution {
    //TC-O(amount.coin) and SC-O(amount)
    //max possible ways
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];//including 0
        dp[0] = 1;//max value, so 1 way to 0 is not keeping any coins
        for (int coin : coins) {//each coin to make amount
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];//add every possible way, so add itself
            }
        }
        return dp[amount];
    }
}