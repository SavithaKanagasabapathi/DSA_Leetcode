class Solution {
    //see current to left
    //rob alternate house so i+(i-2)
    //max((i+(i-2)), i-1), because Rob/skip the house 
    //Rob it: You take the money at nums[i] and add it to the best loot from two houses ago (prev2).
    //Skip it: Because the house right before it had much more money.
    public int rob(int[] nums) {
        //TC-O(N) and SC-O(N)
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max((nums[i] + dp[i - 2]), dp[i - 1]);
        }
        return dp[n - 1];

        //TC-O(N) and SC-O(1)
        // int prev2Dp = 0, prev1Dp = 0, currentDp = 0;
        // for (int num : nums) {
        //     currentDp = Math.max(num + prev2Dp, prev1Dp);
        //     prev2Dp = prev1Dp;
        //     prev1Dp = currentDp;
        // }
        // return currentDp;
    }
}