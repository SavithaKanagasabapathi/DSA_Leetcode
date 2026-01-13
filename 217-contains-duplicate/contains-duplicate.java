class Solution {
    public boolean containsDuplicate(int[] nums) {
        //TC-O(n) and SC-O(n)
        //Using Streams
        //return Arrays.stream(nums).distinct().count() < nums.length;
        //Using Set
        // Set<Integer> set = new HashSet<>();
        // for (int num : nums) {
        //     if (!set.add(num)) {
        //         return true;
        //     }
        // }
        // return false;
        //Using Map
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                return true;
            }
        }
        return false;
    }
}