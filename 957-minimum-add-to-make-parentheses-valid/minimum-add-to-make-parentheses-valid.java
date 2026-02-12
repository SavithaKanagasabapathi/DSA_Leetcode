class Solution {
    //TC-O(N) and SC-O(1)
    public int minAddToMakeValid(String s) {
        int open = 0, lonely = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
            } else if (c == ')') {
                if (open > 0) {
                    open--;//matching close
                } else {
                    lonely++;//lone close
                }
            }
        }
        return open + lonely;
    }
}