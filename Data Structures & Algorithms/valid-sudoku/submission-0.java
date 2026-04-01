class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0 ; i < 9 ; i++) {
            int[] rows = new int[9];
            for(int j=0 ; j < 9 ; j++) {
                if(board[i][j]!='.'){ rows[board[i][j]-'1']+=1;
                if(rows[board[i][j]-'1'] >=2) return false;  
                }     
            } 
            
        }
        for(int i = 0 ; i < 9 ; i++) {
            int[] cols = new int[9];
            for(int j=0 ; j < 9 ; j++) {
                if(board[j][i]!='.') { cols[board[j][i]-'1']+=1;
                if(cols[board[j][i]-'1'] >=2) return false; 
                }      
            }
        }

        for (int box = 0; box < 9; box++) {
    int[] boxes = new int[9];

    int startRow = (box / 3) * 3;
    int startCol = (box % 3) * 3;

    for (int r = startRow; r < startRow + 3; r++) {
        for (int c = startCol; c < startCol + 3; c++) {
            if (board[r][c] != '.') {
                int digit = board[r][c] - '1';
                boxes[digit]++;
                if (boxes[digit] >= 2) return false;
            }
        }
    }
}



        return true;




        
    }
}
