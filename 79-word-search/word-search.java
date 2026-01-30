class Solution {
    //TC-O(N.M.3^L) - N*M cells, 3 directions (excluding where we came from), L length of word
    //SC-O(L) - Depth of recursion stack
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {//check every cell for it's first word
                if (findWord(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean findWord(char[][] board, String word, int index, int row, int col) {
        if (index == word.length()) {
            return true;//full word found
        }
        if (row >= 0 && row < board.length && col >= 0 && col < board[0].length
                && board[row][col] == word.charAt(index)) {
            char temp = board[row][col];
            board[row][col] = '#';//marked
            //next step, go all directions
            boolean found = findWord(board, word, index + 1, row + 1, col)
                    || findWord(board, word, index + 1, row - 1, col)
                    || findWord(board, word, index + 1, row, col + 1)
                    || findWord(board, word, index + 1, row, col - 1);
            board[row][col] = temp;//backtrack
            return found;
        }
        return false;
    }
}