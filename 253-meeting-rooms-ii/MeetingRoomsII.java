import java.util.*;

public class MeetingRoomsII {
    public static void main(String[] args) {
        Solution soln = new Solution();

        int[][] intervals1 = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
        System.out.println(soln.minMeetingRooms(intervals1)); // Expected: 2

        int[][] intervals2 = { { 7, 10 }, { 2, 4 } };
        System.out.println(soln.minMeetingRooms(intervals2)); // Expected: 1
    }
}

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // TC-O(NLOGN) and SC-O(N), in worst case, need to store all n elements in heap,
        // if all meeting overlaps
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);// Sort based on start time
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();// For storing end time
        minHeap.offer(intervals[0][1]);// First end time
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= minHeap.peek()) {
                minHeap.poll();
            }
            minHeap.offer(intervals[i][1]);
        }
        return minHeap.size();
    }
}