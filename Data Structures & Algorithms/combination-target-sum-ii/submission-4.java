class Solution {
    List<List<Integer>> combinations; 
    int target; 
    int[] elements;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.elements = candidates;
        this.target = target; 
        this.combinations = new ArrayList<>();

        backtrack(new ArrayList<>(), 0, 0);
        return this.combinations; 
    }

    public void backtrack(List<Integer> currList, int startIndex, int currSum ) { 
        if(currSum == target ) combinations.add(new ArrayList<>(currList));
        if(currSum > target) return;

        for(int i=startIndex ; i < this.elements.length; i++) { 
            if(i > startIndex && elements[i]== elements[i-1]) continue;
            currSum+=elements[i];
            currList.add(elements[i]);
            backtrack(currList, i+1, currSum);
            currSum-=elements[i];
            currList.remove(currList.size()-1);
        }
    }
}
