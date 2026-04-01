class Solution {
    public boolean hasDuplicate(int[] nums) {
        if(nums.length<=1) return false;
        Set<Integer> uniques = new HashSet<>();
        uniques.add(nums[0]);
        for(int i=1; i< nums.length; i++) {
            if(uniques.contains(nums[i])) return true;
            else uniques.add(nums[i]);
        }
        return false;
    }
}