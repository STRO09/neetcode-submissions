class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1 ; 
        for(int i= 0 ; i < nums.length; i++) {
            if(nums[i]==0) {
                for(int j=i+1; j < nums.length; j++) {
                    product = nums[j]*product;
                }
                int[] zero = new int[nums.length];
                zero[i]=product; 
                return zero; 
            }
            else product = nums[i]*product;    
        } 
        int[] output = new int[nums.length];
        for(int i=0 ; i < nums.length ; i++) {
            output[i] = product/nums[i];
        } 

        return output;     
    }
}  
