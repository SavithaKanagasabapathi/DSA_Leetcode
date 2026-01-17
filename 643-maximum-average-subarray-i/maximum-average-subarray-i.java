class Solution {
    public double findMaxAverage(int[] nums, int k) {
        //TC-O(n) and SC-O(1)
        double sum = 0;
        for (int i = 0; i < k; i++) {//First k window sum
            sum += nums[i];
        }
        double max = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];//Add current and subtract old window first num
            max = Math.max(max, sum);
        }
        return max / k;//avg
    }
}