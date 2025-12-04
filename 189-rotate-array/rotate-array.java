class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        //If k is higher than nums.length
        k = k % n;
        //reverse full array
        reverse(nums, 0, n - 1);
        //reverse first k elements
        reverse(nums, 0, k - 1);
        //reverse k to remaining
        reverse(nums, k, n - 1);
    }

    void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

    }
}