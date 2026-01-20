class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //TC-O(n) and SC-O(k) - O(2n)=O(n) and k is the size deque stores each time
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            //remove from top which is more than k
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.pollFirst();
            }
            //remove less values than i from last
            //while loop to remove all less no's
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (i >= k - 1) {//After i>=2 only need to add in result 
                result[index++] = nums[deque.peekFirst()];
                //first value will be max and store value and not index
            }
        }
        return result;
    }
}