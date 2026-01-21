class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //TC-O(n2^n) and SC-O(n2^n), 2^n subsets, same like subsets
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums, int target, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
        }
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {//i>start, this only skips same no in nums
                //while call from backtrack, i=start, so it will allow in subset [1, 1, 6]
                continue;
            }
            if (nums[i] > target) {
                break;//skip all other nums also, for this step we sort the array
            }
            temp.add(nums[i]);
            backtrack(result, temp, nums, target - nums[i], i + 1);//each time, target-current value
            temp.remove(temp.size() - 1);
        }
    }
}