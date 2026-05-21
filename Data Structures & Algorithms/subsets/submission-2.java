class Solution {
    int[] nums;
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>(); 
        this.nums = nums;
        subsets.add(new ArrayList<>()); 
        backtrack(subsets, new ArrayList<>(), 0);
        return subsets; 
    }

    public void backtrack(List<List<Integer>> subsets, List<Integer> currList, int startIndex) { 
        if( !currList.isEmpty()) subsets.add(new ArrayList<>(currList));
        for(int i=startIndex; i < this.nums.length ; i++ ) { 
            currList.add(nums[i]);
            backtrack(subsets, currList, i+1);
            currList.remove(currList.size() -1);
        }
    }
}
