class Solution {
    public boolean isValid(String s) {
        //TC-O(n) and SC-O(n) O(1) for n times so SC is O(n)
        //Code Golf - Shortest Code
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '{') {
                deque.push('}');
            } else if (c == '(') {
                deque.push(')');
            } else if (c == '[') {
                deque.push(']');
            } else if (deque.isEmpty() || deque.pop() != c) {
                return false;
            }
        }
        return deque.isEmpty();//If empty true, if not extra brackets present so false
    }
}