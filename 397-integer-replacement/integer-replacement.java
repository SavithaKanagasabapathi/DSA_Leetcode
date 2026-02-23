class Solution {
    public int integerReplacement(int n) {
        //TC-O(logn) and SC-O(logn)
        // Map<Long, Integer> memo = new HashMap<>();
        // long longN = n;//if n is int max, n+1 will int overflow, so long
        // return helper(memo, longN);

        //TC-O(logn) and SC-O(1)
        //bit manipulation
        long longN = n;//if n is int max, n+1 will int overflow, so long
        int count = 0;
        while (longN > 1) {//>1
            if ((longN & 1) == 0) {//for even, last will be 0, 0&1=0
                longN >>= 1;
            } else if (longN == 3 || ((longN >> 1) & 1) == 0) { //If odd, +1 or -1
                //if n ends in ..01, like 9, >>1=100&1=0, 
                //basically we need to make 00 to get easily divisible, so -1 here
                longN--;
            } else {//if n ends in ...11, if we ++, it 100, easy divisible by 2
                longN++;
            }
            count++;
        }
        return count;
    }

    private int helper(Map<Long, Integer> memo, long n) {
        int result = 0;
        if (n == 1) {//already on destination
            return 0;
        }
        if (memo.containsKey(n)) {
            result = memo.get(n);
        }
        if (n % 2 == 0) {
            result = helper(memo, n / 2) + 1;//1 for n to n%2
        } else {
            result = Math.min(helper(memo, n + 1), helper(memo, n - 1)) + 1;
        }
        memo.put(n, result);
        return result;
    }
}