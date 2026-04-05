class Solution {
    public int countVowelSubstrings(String word) {
        //TC-O(N) and SC-O(1)
        int count = 0, a = -1, e = -1, i = -1, o = -1, u = -1,
                consonant = -1, minVowel = -1;//last occurence
        for (int j = 0; j < word.length(); j++) {
            char current = word.charAt(j);
            if (current == 'a') {
                a = j;
            } else if (current == 'e') {
                e = j;
            } else if (current == 'i') {
                i = j;
            } else if (current == 'o') {
                o = j;
            } else if (current == 'u') {
                u = j;
            } else {
                consonant = j;
                continue;
            }
            minVowel = Math.min(a, Math.min(e, Math.min(i, Math.min(o, u))));
            if (minVowel > consonant) {
                count += minVowel - consonant;
            }
        }
        return count;
    }
    //cuaeiou, consonant=0, minVowel=2, as u latest is 6
    //count+=2-0=2
    //uaeiou
    //aeiou
}