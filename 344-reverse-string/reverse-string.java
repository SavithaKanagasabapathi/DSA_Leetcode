class Solution {
    public void reverseString(char[] s) {
        //TC-O(N) and SC-O(1)
        int start = 0, end = s.length - 1;
        while (start < end) {
            char temp = s[start];
            s[start++] = s[end];
            s[end--] = temp;
        }
    }
}