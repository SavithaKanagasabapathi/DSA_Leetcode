class Solution {
    //TC-O(N^2) and SC-O(1)
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        //i,j to j,i (transpose)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {//1,1, 2,2, 3,3 are no need to be changed so i+1
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //i,j to i, n-1-j (reverse rows)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {//only reverse half, as other half reversed by 1st half
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }
}