class Solution {
    public String reverseWords(String s) {
        //TC-O(N) and SC-O(N)

        List<String> splittedStrings = Arrays.asList(s.split(" "));
        StringBuilder result = new StringBuilder();
        splittedStrings.forEach(splits -> {
            result.append(new StringBuilder(splits).reverse());
            result.append(" ");
        });
        return result.toString().trim();
    }
}