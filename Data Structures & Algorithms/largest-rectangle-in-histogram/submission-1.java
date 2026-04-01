class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0; 
        for(int i=0 ; i < heights.length ; i++) {

            int rightmost= i+1;
            int leftmost = i;
            while( rightmost < heights.length && heights[rightmost] >= heights[i]) {
                rightmost++;
            }
            while( leftmost >=0 && heights[leftmost] >= heights[i]) {
                leftmost--;
            }
            maxArea = Math.max(maxArea, heights[i]*(rightmost - leftmost -1));
        }
        return maxArea;          
    }
}
