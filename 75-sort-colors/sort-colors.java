class Solution {
    public void sortColors(int[] nums) {
        //Dutch National Flag(DNF)Problem
        //In-place Algorithm operates directly on the input without requiring extra space(Array)
        //0-Red,1-White,2-Blue
        //TC-O(n) and SC-O(1)
        int left = 0, mid = 0, right = nums.length - 1;
        while (mid <= right) {
            if (nums[mid] == 0) {//Move Left
                swap(nums, mid++, left++);
            } else if (nums[mid] == 1) {//Just increment
                mid++;
            } else {//If 2, Move right and don't increment mid, again mid will be in loop for 0/1 check
                swap(nums, mid, right--);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}