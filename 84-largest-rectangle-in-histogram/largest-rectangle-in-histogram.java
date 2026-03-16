class Solution {
    public int largestRectangleArea(int[] heights) {
        //TC-O(N) and SC-O(N)
        int n = heights.length, maxArea = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i <= n; i++) {//0-n, including n
            int currentHeight = i == n ? 0 : heights[i];
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int prevHeight = heights[stack.pop()];
                int prevWidth = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, prevHeight * prevWidth);
            }
            stack.push(i);
        }
        return maxArea;
        //if height is increasing leave it, 
        //if height is decreasing, pop from stack the before rect 
        //and calc area of popped rect or prev rect
        //if we reached n, as if all are increasing, we need to calc area of all rect, 
        //so n height 0 or otherwise heights[i]
        //width=right index-left index -1, if how many no.s btw 2 and 5 = (5-2)-1=2 as 3&4 are inbtw.
        //if stack empty, left index be -1, so right index-(-1)-1=just right index
    }
}