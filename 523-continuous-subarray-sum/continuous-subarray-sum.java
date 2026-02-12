class Solution {
    //TC-O(N) and SC-O(N)
    //Prefix sum = i, i+(i+1),...i+..(i+n)
    //if array is 1, 2, 3, 4, 5, prefix sum is 1, 3, 6, 10, 15 and keep prefix sum of -1 as 0
    //sum of 1-3(2, 3, 4) is prefix sum of 3-(1-1)=3-0=10-1=9
    //sum of 0-4 = prefix sum of 4-(0-1)=4-(-1)=15-0=15
    //sum of i,j%k=0 is same as (prefix sum of j-prefix sum of i-1)%k=0
    //prefix sum of j%k = prefix sum of i-1%k
    //meaning which 2 have same mod value, subarray lies between them
    //if subarray lies from index 0, so map 0, -1 imaginary index
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();//remainder, index
        int sum = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int remainder = sum % k;
            if (map.containsKey(remainder)) {
                if (i - map.get(remainder) >= 2) {//length should be 2 or >2
                    return true;
                }
            } else {
                map.put(remainder, i);
            }
        }
        return false;
    }
}