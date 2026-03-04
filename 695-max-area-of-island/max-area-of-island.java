class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        //TC-O(M*N) and SC-O(M*N), if m.n fully island, recursion stack will be m.n
        int m = grid.length, n = grid[0].length, maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(i, j, grid));
                }
            }
        }
        return maxArea;
    }

    private int dfs(int row, int col, int[][] grid) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
            return 0;
        }
        grid[row][col] = 0;//sink island as no need to dfs again for this
        return 1 + dfs(row + 1, col, grid) + dfs(row - 1, col, grid) + dfs(row, col + 1, grid)
                + dfs(row, col - 1, grid);
    }
}