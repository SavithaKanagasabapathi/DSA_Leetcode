class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        //TC-O(n^2) and SC-O(n), substring and compareTo 
        //Lexicographically is like dictionary wise, which comes first
        //compareTo is disctionary wise
        //a.compareTo(b)=-1 a comes before b
        //a.compareTo(a)=0 a==a
        //b.compareTo(a)=1 b comes after a
        int count = 0, left = 0;
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
            while (count == k) {//see condn is while
                String current = s.substring(left, i + 1);
                if (result == "" || current.length() < result.length()
                        || (current.length() == result.length() && current.compareTo(result) < 0)) {
                    result = current;
                }
                if (s.charAt(left) == '1') {
                    count--;
                }
                left++;
            }
        }
        return result;
    }
}