class Solution {

    List<List<Integer>> subsets;
    int[] nums;
    public List<List<Integer>> subsetsWithDup(int[] nums) {    
        this.subsets = new ArrayList<>();
        this.nums = nums; 
        Arrays.sort(this.nums);
        backtrack(0, new ArrayList<>());
        return subsets;

    }

   public void backtrack(int startIdx, List<Integer> currList) { 
    subsets.add(new ArrayList<>(currList));
    if(startIdx == nums.length ) return;
    for(int i = startIdx ; i < this.nums.length; i++){
        if(i > startIdx && nums[i] == nums[i-1]) continue;
        currList.add(nums[i]);
        backtrack(i+1, currList);
        currList.remove(currList.size() -1 );
    }
   } 
}
