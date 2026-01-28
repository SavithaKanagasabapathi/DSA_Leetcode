class Solution {
    public int[][] kClosest(int[][] points, int k) {
        //TC-O(NLOGK) and SC-O(K)
        //MaxHeap as minimum points near origin
        //√(x1 - x2)2 + (y1 - y2)2, but here other point is origin
        //√(x)2 + (y)2, sqrt will be more complex, so (x)2 + (y)2
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));
        //a-b is minHeap, b-a is maxHeap
        for (int[] num : points) {
            maxHeap.offer(num);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        //If result in sorted way
        int[][] result = new int[k][2];
        while (k > 0) {
            result[--k] = maxHeap.poll();
        }
        return result;

        //Other ways to return
        //return maxHeap.stream().toArray(int[][]::new);
        //return maxHeap.toArray(int[][]::new);

        // return maxHeap.stream()
        //         .sorted(Comparator.comparingInt(p -> p[0] * p[0] + p[1] * p[1]))//ascending order
        //         .toArray(int[][]::new);

        //Or in short way without PriorityQueue,
        //TC-O(NLOGN) and SC-O(N)
        // return Arrays
        //         .stream(points)
        //         .sorted(Comparator.comparingInt(p -> p[0] * p[0] + p[1] * p[1]))
        //         .limit(k)
        //         .toArray(int[][]::new);

        //For descending order, Comparator.comparingInt().reversed();
    }
}