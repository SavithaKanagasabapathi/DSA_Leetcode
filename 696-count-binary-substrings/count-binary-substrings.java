class Solution {
    public int countBinarySubstrings(String s) {
        //TC-O(n) and SC-O(1)
        //Q is how many consecutive same no's of 0 and 1 in substring - give count
        //if eg., 00111 - freq of continous same num - 2,3
        //Take min of prevGrp and currGrp and add it to count
        int count = 0, prevGroup = 0, currGroup = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                currGroup++;
            } else {
                count += Math.min(prevGroup, currGroup);
                prevGroup = currGroup;
                currGroup = 1;
            }
        }
        return count + Math.min(prevGroup, currGroup);
    }
}