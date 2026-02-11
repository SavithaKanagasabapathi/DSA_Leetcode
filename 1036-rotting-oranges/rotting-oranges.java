class Solution {
    //TC-O(M*N) and SC-O(M*N)
    //BFS and not DFS, as DFS will go deep in one branch, but here need to find minutes for each spread
    //if 2, add in Q, count all fresh 1's
    //bfs and check if all rotted else return -1
    //for directions, we need to create array and for loop for all directions, as it's bfs &!recursion
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length, freshCount = 0, minutes = 0;
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        if (freshCount == 0) {//if no fresh, all rotten/empty
            return 0;
        }
        while (!queue.isEmpty() && freshCount > 0) {
            minutes++;
            int size = queue.size();//size will change
            for (int i = 0; i < size; i++) {//poll upto size
                int[] current = queue.poll();
                for (int[] dir : dirs) {
                    int row = dir[0] + current[0];
                    int col = dir[1] + current[1];
                    if (row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == 1) {
                        grid[row][col] = 2;//infect
                        queue.offer(new int[] { row, col });
                        freshCount--;
                    }
                }
            }
        }
        return freshCount == 0 ? minutes : -1;
    }
}