class Solution {

    int maxArea = 0;
    int[][] grid;
    int rows;
    int cols;
    boolean[][] visited;

    public int maxAreaOfIsland(int[][] grid) {

        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
        this.visited = new boolean[rows][cols];

        for(int i=0; i < rows; i++) { 
            for(int j=0; j < cols; j++) { 
                if(grid[i][j]==1 && !visited[i][j])
                    {
                        visited[i][j] = true;
                        int area = dfs(i,j);
                        maxArea = Math.max(area, maxArea);
                    }
            }
        }
        return maxArea;     
    }

    public int dfs(int row, int col) { 
        int up = 0, down=0, left = 0, right = 0;
        if(col+1 < cols && grid[row][col+1]==1 && !visited[row][col+1] )
        {
            visited[row][col+1] = true;
            right = dfs(row, col+1);
        }

        if(col > 0 && grid[row][col-1]==1 && !visited[row][col-1]) 
        {
            visited[row][col-1] = true;
            left = dfs(row, col-1);
        }

        if(row+1 < rows && grid[row+1][col]==1 && !visited[row+1][col] )
        {
            visited[row+1][col] = true;
            down = dfs(row+1, col);
        }

        if(row > 0 && grid[row-1][col]==1 && !visited[row-1][col]) 
        {
            visited[row-1][col] = true;
            up = dfs(row-1, col);
        }

        return 1 + up + down + left + right;
    }
}
