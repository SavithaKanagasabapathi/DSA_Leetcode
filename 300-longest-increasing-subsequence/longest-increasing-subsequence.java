class Solution {
    public int lengthOfLIS(int[] nums) {
        //LIS - strictly increasing subsequence - don't consider duplicate and don't add to length
        //TC-O(N^2) and SC-O(N), DP
        // int n = nums.length, maxLen = 1;//least len is including itself so 1
        // int[] dp = new int[n];
        // Arrays.fill(dp, 1);
        // for (int i = 1; i < n; i++) {//start with second as first (0 index) length will be 1
        //     for (int j = 0; j < i; j++) {//compare with before
        //         if (nums[j] < nums[i]) {
        //             dp[i] = Math.max(dp[i], dp[j] + 1);
        //         }
        //     }
        //     maxLen = Math.max(maxLen, dp[i]);
        // }
        // return maxLen;

        //TC-O(NLogn) and SC-O(N), n operations with binary search log n
        //this array stores first element and greater than first
        //if any element less than existing, it will binary search for insertion point
        //if 0, 1, 1, 3, 6, 4 - it will insert 0, now that we insert, size has to increase +1
        //add 1, so 0,1, next num is also 1, 1 is already present so put 1 in 1 index
        //0, 1, 3, 6, for 4, binary search returns 3rd index, so change 6 to 4
        //0, 1, 3, 4 - size 4
        //but this code will not work for printing LIS only length will be correct
        //eg., [10, 20, 30, 5] o/p will be 5, 20, 30. here 5 cannot be in first as it is coming at last
        //but length is correct
        //tails will be sorted
        //For binary search, u can also do that mid logic like below, 
        //here maxlen is end index as arrays default value be 0, 
        //so if we give n as endIndex, it will consider upto n elements to insert to insert 6, 
        //it will insert atlast as remaining are 0
        //while (i != j) {int m = (i + j) / 2;
        //if (tails[m] < x) i = m + 1;else j = m;}
        //if num present in tails, return index,if not found it gives insertion point as -i-1
        //Like if any num have to be inserted in 1 it gives 0 means -1-1, 
        //so to get insertion point, +1 to nullify -1, -(i) to change -, so -(i+1)
        int n = nums.length, maxLen = 0;
        int[] tails = new int[n];
        for (int num : nums) {
            int i = Arrays.binarySearch(tails, 0, maxLen, num);
            if (i < 0) {
                i = -(i + 1);
            }
            tails[i] = num;//change value of that index to num
            maxLen = Math.max(maxLen, i + 1);//since we added i, size will be increased, 
            //so new size is i+1, or u can write if(i==size) size++;
        }
        return maxLen;
    }
}