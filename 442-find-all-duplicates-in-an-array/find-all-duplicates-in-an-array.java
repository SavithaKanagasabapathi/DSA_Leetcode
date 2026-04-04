class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        //TC-O(n) and SC-O(1)
        //negate value of curr -1 index to negative
        //if duplicate, it will be negative already
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int value = Math.abs(nums[i]);
            int index = value - 1;
            if (nums[index] < 0) {
                result.add(value);
            } else {
                nums[index] *= -1;
            }
        }
        return result;
    }
    //Also do it in below ways,
    //HashSet: O(n) time O(n) space.
    //Sorting: O(n log n) time O(1) space.
    //Binary Search on Range: O(n log n) time O(1) space
}