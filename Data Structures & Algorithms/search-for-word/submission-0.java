class Solution {
    Set<String> visited;
    char[][] board;
    String word;
    int rows; 
    int cols;
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.visited = new HashSet<>();
        this.word = word;
        this.rows = board.length;
        this.cols = board[0].length;
        for(int i= 0 ; i < rows; i++) {
            for(int j = 0 ; j < cols; j++) {
                if(search(i,j,0))
                    return true; 
            }
        }
        return false;  
    }

    public boolean search(int i, int j, int currIdx) { 
        if(currIdx == this.word.length()) return true;
        if(i < 0 || j < 0 || i >= this.rows || j >= this.cols) return false;
        if(visited.contains(i+""+j)) return false;
        if(this.word.charAt(currIdx) == board[i][j]) currIdx++;
        else return false;
        visited.add(i+""+j); 

        boolean up = search(i-1, j, currIdx );
        boolean down = search(i+1, j, currIdx );
        boolean left = search(i, j-1, currIdx );
        boolean right = search(i, j+1, currIdx );

        visited.remove(i+""+j);

        return (up || down || left || right);
    }
}
