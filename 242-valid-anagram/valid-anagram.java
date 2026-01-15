class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        //Using ASCII only for small case English letters
        //TC-O(n) and SC-O(1)
        // int[] count = new int[26];//Count alphabets count
        // for (int i = 0; i < s.length(); i++) {
        //     count[s.charAt(i) - 'a']++;//char-97
        //     count[t.charAt(i) - 'a']--;
        // }
        // for (int cnt : count) {
        //     if (cnt > 0) {
        //         return false;
        //     }
        // }
        // return true;

        //Using Map for letters and special chars and emoji's
        //TC-O(n) and SC-O(k), where k is unique char
        //codePoints are char/num/specialchar/emoji
        // Map<Integer, Integer> map = new HashMap<>();
        // s.codePoints().forEach(code -> map.put(code, map.getOrDefault(code, 0) + 1));
        // t.codePoints().forEach(code -> map.put(code, map.getOrDefault(code, 0) - 1));
        // return map.values().stream().allMatch(count -> count == 0);

        //Using Sort
        //TC-O(nlogn) and SC-O(1) or O(n), depending on sort
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        return Arrays.equals(sArray, tArray);
    }
}