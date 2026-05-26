class Solution {
    int[] nums;
    List<List<Integer>> permutations;
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        this.permutations = new ArrayList<>();
        backtrack(0);
        return permutations;
    }

    public void backtrack(int startIdx) { 
        if(startIdx == nums.length) { 
            List<Integer> permutation = new ArrayList<>();
            for(int num: nums) permutation.add(num);
            permutations.add(permutation);
        }

        for( int i = startIdx ; i < nums.length ; i++ ) { 
            swap(startIdx, i);
            backtrack(startIdx+1);
            swap(startIdx, i);
        }
    }

    public void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
