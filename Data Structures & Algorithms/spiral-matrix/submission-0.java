class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int left = 0 ;
        int top = 0;
        int right = matrix[0].length -1;
        int bottom = matrix.length - 1;

        List<Integer> result = new ArrayList<>();
        int currI =0;
        int currJ = 0;
        while(left <=right && top <=bottom) { 
            for(int i=left; i<=right; i++) { 
                result.add(matrix[currI][i]);
            }
            top++;
            currJ=right;
            for(int j=top; j<=bottom; j++) { 
                result.add(matrix[j][currJ]);   
            }
            right--;
            currI=bottom;

            if(left <=right && top <=bottom) { 
                for(int i=right; i>=left; i--) { 
                    result.add(matrix[currI][i]);
                }
                bottom--;
                currJ=left;
                for(int j=bottom; j>=top; j--) { 
                    result.add(matrix[j][currJ]);   
                }
                left++; 
                currI=top;  
            }
        }

        return result;
    }
}