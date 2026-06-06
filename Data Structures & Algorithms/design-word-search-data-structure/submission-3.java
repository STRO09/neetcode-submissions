public class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isWord;
}

class WordDictionary {
    TrieNode root;
    boolean answer;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        boolean ans = findNode(root, word, 0);
        return ans;
    }

    public boolean findNode(TrieNode node, String word, int idx) {
        TrieNode curr = node;
        if(curr == null) return false;
        if(idx == word.length()) return curr.isWord ;
        char ch = word.charAt(idx);
        if (ch == '.') {
            for (int i = 0; i < 26; i++) {
                answer = findNode(curr.children[i], word, idx+1);
                if(answer) break;
            }
        } else {
            answer = findNode(curr.children[ch - 'a'], word, idx+1);
        }
        return answer;
    }
}
