class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> letterscount1 = new HashMap<>();
        for(int i=0; i< s.length(); i++) {
            if(!letterscount1.containsKey(s.charAt(i))) letterscount1.put(s.charAt(i),1);
            else letterscount1.put(s.charAt(i), letterscount1.get(s.charAt(i))+1);
        } 
        Map<Character, Integer> letterscount2 = new HashMap<>();
        for(int i=0; i< t.length(); i++) {
            if(!letterscount2.containsKey(t.charAt(i))) letterscount2.put(t.charAt(i),1);
            else letterscount2.put(t.charAt(i), letterscount2.get(t.charAt(i))+1);
        } 

        if(letterscount1.equals(letterscount2)) return true;
        return false;     
    }
}
