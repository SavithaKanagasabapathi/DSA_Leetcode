class Solution {
    public int findKthLargest(int[] nums, int k) {
        //TC-O(Nlogk) and SC-O(K)
        //Going thro' N elements, adding and removing k (2*logk), storing only k elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();//minHeap stores smallest in top
        //Why minHeap instead of maxHeap here, in maxHeap we need to store n elements and poll k 
        //in minHeap, only storing k elements
        for (int num : nums) {
            if (minHeap.size() < k) {
                minHeap.offer(num);
            } else if (num > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(num);
            }
        }
        return minHeap.peek();
    }
}