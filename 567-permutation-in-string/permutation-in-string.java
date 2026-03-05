class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //O(N) and O(1) n is s2 length
        if (s1.length() > s2.length()) {//if s1 is greater than s2, permutation of s1 can't be in s2
            return false;
        }
        int[] s1count = new int[26];
        int[] s2count = new int[26];
        int match = 0;
        for (int i = 0; i < s1.length(); i++) {//upto s1 length, get count of both
            s1count[s1.charAt(i) - 'a']++;
            s2count[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (s1count[i] == s2count[i]) {
                match++;
            }
        }
        for (int i = 0; i < s2.length() - s1.length(); i++) {//0 to s2 length-window size
            if (match == 26) {//in any loop, if match 26 return true
                return true;
            }
            int left = s2.charAt(i) - 'a', right = s2.charAt(i + s1.length()) - 'a';
            //left-window starting, right-next window starting
            //left leaving
            s2count[left]--;
            if (s1count[left] == s2count[left]) {
                match++;
            } else if (s1count[left] - 1 == s2count[left]) {
                match--;
            }
            //right entering after window size
            s2count[right]++;
            if (s1count[right] == s2count[right]) {
                match++;
            } else if (s1count[right] + 1 == s2count[right]) {
                match--;
            }
        }
        return match == 26;
        //eg., s1=abc, s2=dcbae
        //permutation of ab - ab, ba, times=n!
    }
}