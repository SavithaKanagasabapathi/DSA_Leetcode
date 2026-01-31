import java.util.*;

public class MeetingRooms {
    public static void main(String[] args) {
        Solution soln = new Solution();

        int[][] intervals1 = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
        System.out.println(soln.canAttend(intervals1)); // Expected: false

        int[][] intervals2 = { { 7, 10 }, { 2, 4 } };
        System.out.println(soln.canAttend(intervals2)); // Expected: true
    }
}

class Solution {
    public boolean canAttend(int[][] intervals) {
        // TC-O(NLOGN) and SC-O(1)
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);// Sort based on start time
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1][1] > intervals[i][0]) {// end>start
                return false;
            }
        }
        return true;
    }
}