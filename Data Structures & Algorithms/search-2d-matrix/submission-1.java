class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0; 
        int col = 0; 
        int left = 0;
        int right = matrix[0].length - 1;
        while( left <= right && row < matrix.length) { 
            int mid = left + (right - left)/2; 
            if(target > matrix[row][right]) { 
                row++;
            }
            else if(target == matrix[row][mid]) {
                return true;
            }
            else if(target >matrix[row][mid]) {
                left = mid+1;
            }
            else {
                right = mid-1;
            }
        } 
        return false;     
    }
}
