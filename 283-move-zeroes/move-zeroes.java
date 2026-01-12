class Solution {
    public void moveZeroes(int[] nums) {
        //If non zero, move left, 
        //if we move zeros to right, relative position of non zero will be changed.
        //TC-O(n) and SC-O(1)
        int nonzeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[nonzeroIndex];
                nums[nonzeroIndex] = temp;
                nonzeroIndex++;
            }
        }
    }
}
