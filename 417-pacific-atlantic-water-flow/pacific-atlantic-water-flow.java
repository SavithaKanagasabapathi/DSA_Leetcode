class Solution {
    //TC-O(M*N) and SC-O(M*N), 2 boolean matrix and recursion stack
    //2 boolean m*n for atlantic and pacific, loop and both true add that cell and return result
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {//left and right
            dfs(heights, i, 0, heights[i][0], pacific);
            dfs(heights, i, n - 1, heights[i][n - 1], atlantic);//limit is col
        }
        for (int i = 0; i < n; i++) {//top and bottom
            dfs(heights, 0, i, heights[0][i], pacific);
            dfs(heights, m - 1, i, heights[m - 1][i], atlantic);//limit is row
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private void dfs(int[][] heights, int row, int col, int prevHgt, boolean[][] ocean) {
        //corner cell will be called by both oceans, so if any cell already true, return
        // water should flow from middle highest to boundary lowest
        if (row < 0 || row >= heights.length || col < 0 || col >= heights[0].length
                || ocean[row][col] || heights[row][col] < prevHgt) {
            return;
        }
        ocean[row][col] = true;
        dfs(heights, row + 1, col, heights[row][col], ocean);//here prevHgt is current but row is next
        dfs(heights, row - 1, col, heights[row][col], ocean);
        dfs(heights, row, col + 1, heights[row][col], ocean);
        dfs(heights, row, col - 1, heights[row][col], ocean);
    }
}