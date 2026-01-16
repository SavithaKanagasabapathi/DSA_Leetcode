class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //TC-O(n) and SC-O(1)
        //Sorted means 2 pointer
        //non-decreasing order is Ascending with duplicates
        int length = numbers.length;
        int left = 0, right = length - 1;
        while (left < right) {//two pointers should not be same
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[] { left + 1, right + 1 };//In Q, index starting from 1
            } else if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            }
        }
        return new int[] {};
    }
}