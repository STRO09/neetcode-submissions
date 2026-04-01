class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> duplicates = new HashSet<>();
        for(int a : nums) { 
            if(duplicates.contains(a)) return a;
            duplicates.add(a);
        } 

       return 0;  
    }
}
