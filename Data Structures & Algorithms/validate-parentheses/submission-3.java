class Solution {
    public boolean isValid(String s) {
        Stack<Character> braces = new Stack<>();
        Map<Character,Character> map = Map.of( '(', ')', '{', '}', '[', ']');
        for(char c : s.toCharArray()) {
            if(c == '(' || c=='{' || c == '[') braces.push(c);
            if(c == ')' || c=='}' || c == ']') {
                if(braces.size()==0) return false;
                if(braces.size()!=0 && map.get(braces.pop())!=c) return false; 
            }
        }
        if(braces.size()==0)return true;
        else return false;       
    }
}
