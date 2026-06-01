class Solution {
    List<List<String>> palindromeSets;
    String s;
    public List<List<String>> partition(String s) {
        this.palindromeSets = new ArrayList<>();
        this.s = s;
        backtrack(new ArrayList<>(),0);
        return palindromeSets;
    }

    public void backtrack(List<String> currList, int start) { 
        if(start == s.length()) palindromeSets.add(new ArrayList(currList));

        for(int end = start; end < s.length(); end++) { 
            if(checkPalindrome(s.substring(start, end+1))) {
                currList.add(s.substring(start,end+1));
                backtrack(currList, end+1);
                currList.remove(currList.size() -1);
            }

        }
    }

    public boolean checkPalindrome(String s) { 
        int i=0;
        int j=s.length() -1;

        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
