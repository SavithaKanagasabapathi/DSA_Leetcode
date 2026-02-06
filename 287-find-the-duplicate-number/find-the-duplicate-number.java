class Solution {
    public int findDuplicate(int[] nums) {
        //Fast and Slow Pointers
        //TC-O(N) and SC-O(1)
        //To check cycle, we should not take index or numbers - take nums[start] to nums[nums[start]]
        //as it will give duplicate number
        int slow = nums[0], fast = nums[0];
        do {
            slow = nums[slow];//1 jump
            fast = nums[nums[fast]];//2 jump
        } while (slow != fast);

        fast = nums[0];//from first
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;//at start of duplicate, slow and fast meets

        //Binary Search logn
        //TC-O(NLOGN) and SC-O(1), n times logn
        //we are not binary searching nums, instead 1 to n-1 as in request saying nums starting from 1
        //since we have duplicate upto n-1 
        //after getting mid, in total nums, which are smaller or equal to mid - count
        //If count is greater than mid, duplicate will be in 1 to mid, else mid to n-1
        // int start = 1, end = nums.length - 1;
        // while (start < end) {
        //     int mid = start + (end - start) / 2;
        //     int count = 0;
        //     for (int num : nums) {
        //         if (num <= mid) {
        //             count++;
        //         }
        //     }
        //     if (count > mid) {
        //         end = mid;
        //     } else {
        //         start = mid + 1;
        //     }
        // }
        // return start;
    }
}