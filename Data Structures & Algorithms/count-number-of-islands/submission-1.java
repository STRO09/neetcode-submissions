class Solution {
    char[][] grid;
    int rows;
    int cols; 
    boolean[][] visited;
    int totalIslands = 0;

    public int numIslands(char[][] grid) {
        this.grid = grid;   
        this.rows = grid.length;
        this.cols = grid[0].length;
        visited = new boolean[rows][cols];

        for(int i =0; i < rows; i++) { 
            for(int j =0; j < cols; j++) { 
                if(grid[i][j]=='1' && !visited[i][j])
                {    
                    dfs(i, j);
                    totalIslands++;
                }
            }
        }
        return totalIslands;

    }
    public void dfs(int row, int col) {
        if(visited[row][col]) return;
        visited[row][col] = true;
        if(grid[row][col] == '1') {
            if(col > 0) dfs(row, col-1);
            if(col + 1 < cols) dfs(row,col+1);
            if(row> 0) dfs(row-1,col);
            if(row + 1 < rows) dfs(row+1,col);
        }
        else return;
    }


}
