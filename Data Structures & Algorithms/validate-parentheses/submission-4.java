class Solution {
    public boolean isValid(String s) {
        Stack<Character> braces = new Stack<>();
        String uk = "(){}[]";
        for(char c : s.toCharArray()) {
            if(uk.indexOf(c)%2==0) braces.push(c);
            if(uk.indexOf(c)%2!=0) {
                if(braces.size()==0) return false;
                if(braces.size()!=0 && braces.pop()!=uk.charAt(uk.indexOf(c)-1)) return false; 
            }
        }
        if(braces.size()==0)return true;
        else return false;       
    }
}
