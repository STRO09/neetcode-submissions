class TrieNode { 
    boolean isWord; 
    String word;
    TrieNode[] children = new TrieNode[26];
}

class Solution {
    List<String> presentWords; 
    char[][] board;
    boolean[][] visited;
    TrieNode root;
    int rows;
    int cols;

    public Solution() { 
        this.presentWords = new ArrayList<>();
        this.root = new TrieNode();
    }

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        this.rows = board.length;
        this.cols = board[0].length;
        this.visited = new boolean[rows][cols];

        for(String word : words) { 
            insert(word);
        }

        for(int i=0; i < rows; i++) { 
            for(int j=0; j < cols; j++) { 
                traverseBoard(i,j, root);
            }
        }

        return presentWords; 
    }

    public void traverseBoard(int startRow, int startCol, TrieNode currNode) { 
        char ch = board[startRow][startCol];
        if(visited[startRow][startCol] || currNode.children[ch - 'a'] == null) return;
        currNode = currNode.children[ch - 'a'];
        if(currNode.isWord && !presentWords.contains(currNode.word)) presentWords.add(currNode.word);

        if(startCol + 1 < cols ) 
            {
                visited[startRow][startCol] = true;
                traverseBoard(startRow, startCol +1, currNode);
                visited[startRow][startCol] = false;
            }
        if(startRow + 1 < rows ) 
            {
                visited[startRow][startCol] = true;
                traverseBoard(startRow + 1, startCol, currNode);
                visited[startRow][startCol] = false;
            }
        if(startCol > 0)
            {
                visited[startRow][startCol] = true;
                traverseBoard(startRow, startCol - 1, currNode);
                visited[startRow][startCol] = false;
            }            
        if(startRow > 0) 
            {
                visited[startRow][startCol] = true;
                traverseBoard(startRow - 1, startCol, currNode);
                visited[startRow][startCol] = false;
            }
    }
    
    public void insert(String word) { 
        TrieNode curr = root;
        if(word.equals("")) return;
        StringBuilder str = new StringBuilder();
        for(char ch : word.toCharArray()) { 
            if(curr.children[ch - 'a'] == null) 
                curr.children[ch - 'a'] = new TrieNode();
            curr = curr.children[ch - 'a'];
            str.append(ch);
            curr.word = str.toString();
        }
        curr.isWord = true;

    }
}
