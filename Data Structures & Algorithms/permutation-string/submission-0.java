class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false; 

        int[] freqsub = new int[26];
        int[] window = new int[26];

        for(int i=0 ; i < s1.length(); i++) {
            freqsub[s1.charAt(i)- 'a']++;
        } 
        int left=0;
        int right = s1.length() -1; 
        boolean result =false;
        while(right < s2.length()) {
            result = matchForWindow(s1, s2, left, right, freqsub, window); 
            if(result==true) return true;
            window = new int[26];
            right++;
            left++;
        }
        if(result==false) return false;
        else return true; 
    }

    public static boolean matchForWindow(String s1, String s2, int left, int right, int[] freqsub, int[] window) {
        for(int i=left ; i <= right; i++) {
            window[s2.charAt(i)- 'a']++;
        }

        for(int i=0; i< 26; i++) {
            if(window[i]!=freqsub[i]) return false;  
        } 
        return true;
    }
}
