class Solution {
    List<List<Integer>> permutations;
    int[] nums;
    int numsize;
    boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        this.permutations = new ArrayList<>();
        this.nums = nums;
        this.numsize = nums.length;
        this.used = new boolean[nums.length];
        backtrack(permutations, new ArrayList<>());
        return permutations;
    }

    public void backtrack(List<List<Integer>> permutations, List<Integer> currList) {
        if (currList.size() == numsize) {
            permutations.add(new ArrayList<>(currList));
            return;
        }

        for (int i = 0; i < numsize; i++) {
            if (used[i])
                continue;
            currList.add(nums[i]);
            used[i] = true;
            backtrack(permutations, currList);
            used[i] = false;
            currList.remove(currList.size() - 1);
        }
    }
}
