class Solution {
    public boolean rotateString(String s, String goal) {
        //TC-O(n) and SC-O(n), created twice the n, concatenation and contains
        //return s.length() == goal.length() && (s + s).contains(goal);

        //TC-O(n^2) and SC-O(1), in worst case, s be aaaab, g be abaaa
        if (s.length() != goal.length()) {
            return false;
        } else if (s == goal) {
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == goal.charAt(0) && check(s, goal, i)) {
                return true;
            }
        }
        return false;

    }

    private boolean check(String s, String g, int startingIndex) {
        int n = s.length();//both strings same length
        for (int j = 0; j < n; j++) {
            if (s.charAt((startingIndex + j) % n) != g.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}