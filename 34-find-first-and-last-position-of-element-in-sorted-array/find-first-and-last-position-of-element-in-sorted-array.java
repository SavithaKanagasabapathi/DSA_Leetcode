class Solution {
    public int[] searchRange(int[] nums, int target) {
        //TC-O(logn) and SC-O(1) Even if 2 times Binary Search 2logn is logn
        return new int[] { findIndex(nums, target, true), findIndex(nums, target, false) };
    }

    public int findIndex(int[] nums, int target, boolean isFirst) {
        int left = 0, right = nums.length - 1, index = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                index = mid;
                if (isFirst) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return index;
    }
}