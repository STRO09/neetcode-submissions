public class TrieNode { 
    TrieNode[] children = new TrieNode[26];
    boolean isWord;
}


class PrefixTree {
    TrieNode root;
    public PrefixTree() {
        this.root = new TrieNode();   
    }

    public void insert(String word) {
        TrieNode curr = root;
        for(char ch : word.toCharArray()) { 
            int idx = ch-'a';
            if(curr.children[idx]==null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for(char ch : word.toCharArray()) { 
            int idx = ch-'a';
            if(curr.children[idx]==null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char ch : prefix.toCharArray()) { 
            int idx = ch-'a';
            if(curr.children[idx]==null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return true;

    }
}
