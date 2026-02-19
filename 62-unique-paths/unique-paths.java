class Solution {
    public int uniquePaths(int m, int n) {
        //TC-O(M*N) and SC-O(M*N)
        //only move right/down
        // int[][] dp = new int[m][n];
        //first row and col be 1, start(0,0) be 1, to reach 0,1 only by right and not down from img row
        //likewise first row and col is 1
        // for (int i = 0; i < n; i++) {
        //     dp[0][i] = 1;//first row
        // }
        // for (int i = 0; i < m; i++) {
        //     dp[i][0] = 1;//first col
        // }
        // for (int i = 1; i < m; i++) {
        //     for (int j = 1; j < n; j++) {
        //         dp[i][j] = dp[i][j - 1] + dp[i - 1][j];//to reach i,j-left to right and top to bottom
        //     }
        // }
        // return dp[m - 1][n - 1];

        //TC-O(M*N) and SC-O(N)
        //only move right/down
        int[] dp = new int[n];//one array upto col n
        //first row and col be 1, start(0,0) be 1, to reach 0,1 only by right and not down from img row
        //likewise first row and col is 1
        Arrays.fill(dp, 1);//fill everything by 1 now
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //111->123->136, first be 1, next row dp of that col before + col before in new row
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];

        //SC-O(1)
        //(m+n-2)!/(m-1)!(n-1)! to calculate unique paths 
        //cons is Integer overflow, so use long
    }
}