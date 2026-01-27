class MedianFinder {
    PriorityQueue<Integer> maxHeap, minHeap;

    public MedianFinder() {
        //To find median, sort and if odd-middle num or middle 2 nums sum/2
        //Here this is stream, we don't know how many will come, so adding in heaps
        //maxHeap is smallest first half, we need last greater num, so maxHeap
        //minHeap is largest second half, we need first smallest num, so minHeap 
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());//For maxHeap add reverseOrder
        minHeap = new PriorityQueue<>();//Default is minHeap
    }

    //TC-O(logn) and SC-O(N), add and remove in heap is O(logn)
    public void addNum(int num) {
        //1.maxHeap peek should be less than maxHeap peek
        //2.maxHeap size can be greater than minHeap by 1
        //3.minHeap size should not be greater than maxHeap
        maxHeap.offer(num);
        if (minHeap.size() > 0 && maxHeap.peek() > minHeap.peek()) {
            minHeap.offer(maxHeap.poll());
        }
        if (maxHeap.size() - minHeap.size() > 1) {
            minHeap.offer(maxHeap.poll());
        }
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    //TC-O(1) and SC-O(1)
    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();//If odd num, median is middle num
        }
        return (maxHeap.peek() + minHeap.peek()) / 2.0;//If even num, median is (a+b)/2, 
        //they need decimal values, so return type is double, so dividing by 2.0
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */