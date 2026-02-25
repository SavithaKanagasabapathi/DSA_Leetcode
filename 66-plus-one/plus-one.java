class Solution {
    public int[] plusOne(int[] digits) {
        //TC-O(1) and SC-O(1), for 999 edge case - TC-O(N) and SC-O(N)
        //Simply add last digit +1, if it is <9, if it is 9 - set as 0
        //if all 999, create result[] and set first as 1 and others are 0 by default
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[n + 1];
        result[0] = 1;//others are 0 by default
        return result;
    }
}