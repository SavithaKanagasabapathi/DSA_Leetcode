class Solution {
    public int findMin(int[] nums) {
        //TC-O(n) and SC-O(1)
        int left = 0, right = nums.length - 1, result = nums[0];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= nums[0]) {
                left = mid + 1;
            } else {
                result = nums[mid];
                right = mid - 1;
            }
        }
        return result;
        //TC-O(n) and SC-O(1)
        // int left = 0, right = nums.length - 1;
        // while (left < right) {//find index where left and right same so not <equals
        //     int mid = left + (right - left) / 2;
        //     if (nums[mid] > nums[right]) {
        //         left = mid + 1;
        //     } else {
        //         right = mid;//mid may be min 
        //     }
        // }
        // return nums[left];//left and right in same index after loop be minimum
    }
}
