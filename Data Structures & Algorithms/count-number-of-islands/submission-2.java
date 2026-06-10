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

        for(int i=0; i < rows; i ++) { 
            for(int j=0; j < cols; j++) {
                if(grid[i][j]=='1' && !visited[i][j]) {
                    bfs(i,j);
                    totalIslands++;
                }        
            }
        }

        return totalIslands;

    }

    public void bfs(int row, int col) { 

        Queue<int[]> queue = new LinkedList<>();
        // if(visited[row][col]) return;
        queue.offer(new int[]{row, col});
        visited[row][col] = true;
        
        while(!queue.isEmpty()) { 
            int[] cell = queue.poll();
            int currR = cell[0];
            int currC = cell[1];

            // left
            if(currC > 0 && grid[currR][currC -1]=='1' 
                && !visited[currR][currC-1]) { 
                queue.offer(new int[]{currR, currC-1});
                visited[currR][currC-1] = true;
            }

            // right
            if(currC + 1 < cols && grid[currR][currC+1]=='1' 
                && !visited[currR][currC+1]) { 
                queue.offer(new int[]{currR, currC+1});
                visited[currR][currC+1] = true;
            }

            // up
            if(currR > 0 && grid[currR-1][currC]=='1' 
                && !visited[currR-1][currC]) { 
                queue.offer(new int[]{currR-1, currC});
                visited[currR-1][currC] = true;
            }

            // down
            if(currR + 1 < rows && grid[currR+1][currC]=='1' 
                && !visited[currR+1][currC]) { 
                queue.offer(new int[]{currR+1, currC});
                visited[currR+1][currC] = true;
            }

        }
    }





}
