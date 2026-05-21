class Solution {

    int target;
    int[] nums;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        this.target = target;
        this.nums = nums;
        List<List<Integer>> combinations = new ArrayList<>();
        backtrack(combinations, new ArrayList<>(), 0, 0);
        return combinations;  
    }

    public void backtrack(List<List<Integer>> combinations,List<Integer> currList, int currSum, int startIndex) { 
        if(currSum == this.target && !combinations.contains(currList)) combinations.add(new ArrayList<>(currList));
        if(currSum > target) return;
        for(int i=startIndex ; i < this.nums.length ; i++  ) { 
            currSum+=nums[i];
            currList.add(nums[i]);
            backtrack(combinations, currList, currSum, i);
            backtrack(combinations, currList, currSum, i+1);
            currSum-=nums[i];
            currList.remove(currList.size() - 1);
        }
    }
}
