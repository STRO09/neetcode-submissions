class Solution {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int max = height[0];
        left[0] = 0;
        for(int i=1 ; i < height.length; i++) {
            max = Math.max(max, height[i-1]);
            left[i]=max;
        }
        max = height[height.length -1];
        right[height.length-1] = 0;
        for(int i=height.length -2; i >=0 ; i--) {
            max = Math.max(max, height[i+1]);
            right[i]= max;
        }
        int water =0;
        for(int i=1 ; i < height.length -1 ; i++) {

            if(Math.min(left[i], right[i] ) -height[i] >= 0) {
                water += Math.min(left[i], right[i] ) -height[i];
            }
        } 
        return water ;     
    }
}
