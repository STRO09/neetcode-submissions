class Solution {
    public int trap(int[] height) {
        int[] left = new int[height.length];  
        int[] right = new int[height.length]; 
        int watersum = 0 ;   
        left[0] = -1 ;
        right[height.length -1 ] = -1; 
        int maxleft = 0, maxright = 0;
        for(int i= 1; i < height.length ; i++) {
            maxleft = Math.max(maxleft, height[i-1]); 
            left[i] = maxleft ; 
        }  
        for(int i= height.length - 2 ; i >= 0 ; i--) {
            maxright = Math.max(maxright, height[i+1]); 
            right[i] = maxright; 
        }   
        for(int i =  1 ; i < height.length - 1 ; i ++ ) { 
            if((Math.min(left[i], right[i]) - height[i] )>0) watersum += Math.min(left[i], right[i]) - height[i]; 
        } 
        return watersum;  
    } 
}
