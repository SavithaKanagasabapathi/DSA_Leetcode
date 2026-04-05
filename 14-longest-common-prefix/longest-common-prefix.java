class Solution {
    public String longestCommonPrefix(String[] strs) {
        //TC-O(S) and SC-O(1), S is the sum of all chars in in strs
        //take 1st str as prefix, compare with others 
        //if take other str, if that str.indexOf(prefix), if that str contains prefix fully
        //it's index will be 0, two words can't be same, 
        //so remove prefix last word until prefix contains in str
        //Savitha.indexOf(avi)=1
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
}