class Solution {
    //TC-O(logn) and SC-O(1) - Binary search
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {//<= as here we can have left and right equal
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;//if target present, return mid
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;//after loop, mid<target, so left=mid+1 giving correct index to insert
    }
}