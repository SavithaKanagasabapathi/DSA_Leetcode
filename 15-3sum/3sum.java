class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //TC-O(n^2) and SC-O(logn to n)
        //Sort-nlogn and 2 loops - n^2 - n^2 dominate
        //Space depends on sort(Dual-pivot quicksort) and output list
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);//To use 2 ptr, we need to sort
        for (int i = 0; i < nums.length - 2; i++) {//2 ptrs so -2
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            } //Skip duplicate number
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        //iterate +1 for each duplicate until no duplicates
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;//iterate again for next number
                    right--;
                } else if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                }
            }
        }
        return result;
    }
}