class Solution {
    List<List<String>> letters;
    String digits; 
    int digitslength;
    List<String> combinations;
    public List<String> letterCombinations(String digits) {
        if(digits.equals("")) return new ArrayList<>();
        this.letters = new ArrayList<>();
        this.combinations =  new ArrayList<>();
        letters.add(List.of("a","b","c"));
        letters.add(List.of("d","e","f"));
        letters.add(List.of("g","h","i"));
        letters.add(List.of("j","k","l"));
        letters.add(List.of("m","n","o"));
        letters.add(List.of("p","q","r","s"));
        letters.add(List.of("t","u","v"));
        letters.add(List.of("w","x","y", "z"));   
        this.digits = digits;
        this.digitslength = digits.length();

        backtrack(new StringBuilder(), 0);
        return combinations;
    }
    public void backtrack(StringBuilder newStr, int currIdx){
        if(currIdx == digitslength ) { 
          this.combinations.add(newStr.toString());
          return;  
        }
        List<String> currStr = letters.get(digits.charAt(currIdx) - '2');
        for(String ch : currStr) { 
            newStr.append(ch);
            backtrack(newStr,currIdx +1);
            newStr.deleteCharAt(newStr.length() -1);
        }
    }
}
