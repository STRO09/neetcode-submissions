class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length ==0) return 0;
        Arrays.sort(nums);
        int max = Integer.MIN_VALUE;
        int lastnum = nums[0];
        int length = 1;
        for(int i=1 ; i < nums.length ; i++) {
            if(nums[i]==lastnum+1) {
                length++;
                lastnum++;
            }
            else if(nums[i]>lastnum+1) {
                max = Math.max(max,length);
                length = 1;
                lastnum = nums[i];
            }
        } 
        return Math.max(max,length);
       
    }
}
