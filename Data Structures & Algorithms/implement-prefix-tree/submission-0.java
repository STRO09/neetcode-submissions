public class TrieNode { 
    TrieNode[] children;
    boolean isWord;

    public TrieNode(boolean isWord) { 
        this.isWord = isWord;
        this.children = new TrieNode[26];
    }
}


class PrefixTree {
    TrieNode root;
    public PrefixTree() {
        this.root = new TrieNode(false);   
    }

    public void insert(String word) {
        TrieNode curr = root;
        for(char ch : word.toCharArray()) { 
            if(curr.children[ch-'a']==null) {
                curr.children[ch-'a'] = new TrieNode(false);
            }
            curr = curr.children[ch-'a'];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for(char ch : word.toCharArray()) { 
            if(curr.children[ch-'a']==null) {
                return false;
            }
            curr = curr.children[ch-'a'];
        }
        if(curr.isWord) return true;
        else return false;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char ch : prefix.toCharArray()) { 
            if(curr.children[ch-'a']==null) {
                return false;
            }
            curr = curr.children[ch-'a'];
        }
        return true;

    }
}
