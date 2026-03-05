class Solution {
    public int minDistance(String word1, String word2) {
        //TC-O(M.N) and SC-O(M.N)
        //Similar to Largest Common subsequence
        // int m = word1.length(), n = word2.length();
        // int[][] dp = new int[m + 1][n + 1];//min operations of length i, j 0-m+1,0-n+1
        // for (int i = 0; i <= m; i++) {
        //     dp[i][0] = i;//i times delete word1 letters to make empty as word2
        // }
        // for (int j = 0; j <= n; j++) {
        //     dp[0][j] = j;//j times add word1 letters to make as word2
        // }
        // for (int i = 1; i <= m; i++) {//length 1 to m and n as length 0 will be 0
        //     for (int j = 1; j <= n; j++) {
        //         if (word1.charAt(i - 1) == word2.charAt(j - 1)) {//ij length min operations
        //             //i length but index starting at 0, so i-1 char and j-1 char
        //             //if both same, no need of any operations keep min operations of [i-1][j-1]
        //             dp[i][j] = dp[i - 1][j - 1];
        //         } else {
        //             int insert = dp[i][j - 1];
        //             int delete = dp[i - 1][j];
        //             int replace = dp[i - 1][j - 1];
        //             dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
        //             //1 min operation + remaining previous operations
        //         }
        //     }
        // }
        // return dp[m][n];
        //eg., abd, acd
        //dp[0][0]=0 both are empty and same
        //dp[1][1]-i-1==j-1 - a - so dp[0][0]
        //dp[2][2]-i-1!=j-1 - b and c
        //insert-abcd acd-c inserted at index 2 in abcd and c is present in index 1 in acd=i, j-1
        //delete-ad acd-as c deleted, index is in 1 in ad and d is in 2=i-1, j
        //replace-acd acd-c is in index 1 in both=i-1, j-1

        //TC-O(M.N) and SC-O(N)
        int m = word1.length(), n = word2.length();
        int[] dp = new int[n + 1];
        for (int j = 0; j <= n; j++) {
            dp[j] = j;
        }
        for (int i = 1; i <= m; i++) {
            int prevDiagonal = dp[0]; // Stores dp[i-1][j-1]
            dp[0] = i; // Current row's base case (deletions)
            for (int j = 1; j <= n; j++) {
                int temp = dp[j]; // Store dp[i-1][j] for the next iteration's diagonal
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[j] = prevDiagonal;
                } else {
                    // Min of: Replace (prevDiagonal), Insert (dp[j-1]), Delete (dp[j])
                    dp[j] = 1 + Math.min(prevDiagonal, Math.min(dp[j - 1], temp));
                }
                prevDiagonal = temp;
            }
        }
        return dp[n];
    }
}