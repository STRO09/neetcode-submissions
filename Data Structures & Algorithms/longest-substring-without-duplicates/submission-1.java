class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxLen = 0;

        boolean[] seen = new boolean[128]; // ASCII

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            while (seen[c]) {
                seen[s.charAt(left)] = false;
                left++;
            }

            seen[c] = true;
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}