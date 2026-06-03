class Solution {
    List<List<String>> solutions; 
    int n;
    char[][] board;
    Set<Integer> skiprows;
    Set<Integer> diag1; // y =  x
    Set<Integer> diag2; // y = -x
    public List<List<String>> solveNQueens(int n) {
        this.solutions = new ArrayList<>();
        this.n = n;  
        this.board = new char[n][n];
        this.skiprows = new HashSet<>();
        this.diag1 = new HashSet<>();
        this.diag2 = new HashSet<>();

        backtrack(0,0);
        return solutions;
    }

    public void backtrack(int col, int row) {
        if(row >= n) {
            return;
        }  
        if(col >= n) { 
            addSolution();
            return;
        }
        if(!skiprows.contains(row) &&
           !diag1.contains(col+row) && 
           !diag2.contains(col-row)) { 
            board[row][col] = 'Q';
            skiprows.add(row);
            diag1.add(col+row);
            diag2.add(col-row);
            backtrack(col+1,0);
            board[row][col] = '.';
            skiprows.remove(row);
            diag1.remove(col+row);
            diag2.remove(col-row);
        }

        backtrack(col,row+1);
    }

    public void addSolution() { 
        List<String> solution = new ArrayList<>();
        for(int i=0; i < n; i++) { 
            StringBuilder str = new StringBuilder();
            for(int j=0; j < n; j++) { 
                if(board[i][j]!='Q') str.append('.');
                else str.append('Q');
            }
            solution.add(str.toString());
        }
        solutions.add(solution);
    }
}
