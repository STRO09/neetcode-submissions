class Solution {
    List<String> pairs;
    int n;
    public List<String> generateParenthesis(int n) {
        this.pairs = new ArrayList<>();
        this.n = n;

        pickParentheses(new StringBuilder(), 0, 0);
        return pairs;
    }

    public void pickParentheses(StringBuilder currString, int open, int closed) {
        if(open - closed < 0 || currString.length() == 2*n) { 
            pairs.add(currString.toString());
            return;
        }
        if(open < n) { 
            currString.append('(');
            pickParentheses(currString, open+1, closed);
            currString.deleteCharAt(currString.length() -1);
        }
        if(open - closed > 0) { 
            currString.append(')');
            pickParentheses(currString, open, closed+1);
            currString.deleteCharAt(currString.length() -1);  
        }
    }
}
