//Words with common prefixes (like "apple", "apply") share the same nodes for "appl", saving memory.
//Tries can find all words starting with "app" in O(L) time. 
//A HashSet would have to iterate through every single word.

class TrieNode {
    TrieNode[] children = new TrieNode[26];//for each alphabet
    boolean isEndOfWord = false;
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    //TC-O(L) and SC-O(L*N), L-length of word, N-no. of words
    public void insert(String word) {
        TrieNode current = root;//head
        for (char c : word.toCharArray()) {
            if (current.children[c - 'a'] == null) {
                current.children[c - 'a'] = new TrieNode();
            }
            current = current.children[c - 'a'];//moving ptr to children for leeter next letter
        }
        current.isEndOfWord = true;
    }

    //TC-O(L) and SC-O(1)
    public boolean search(String word) {
        TrieNode current = getLastNode(word);
        return current != null && current.isEndOfWord;
    }

    //TC-O(L) and SC-O(1)
    public boolean startsWith(String prefix) {
        return getLastNode(prefix) != null;
    }

    public TrieNode getLastNode(String word) {
        TrieNode current = root;//head
        for (char c : word.toCharArray()) {
            if (current.children[c - 'a'] == null) {
                return null;
            }
            current = current.children[c - 'a'];
        }
        return current;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */