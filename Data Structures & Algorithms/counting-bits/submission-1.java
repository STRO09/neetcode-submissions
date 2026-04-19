class Solution {
    public int[] countBits(int n) {

        int[] dp = new int[n+1];
        int i =1;
        int mostSignificantReached = 1;
        while(i<=n) { 
            if(mostSignificantReached*2 == i) mostSignificantReached = i;

            dp[i] = 1 + dp[i-mostSignificantReached];
            i++;
        }
        return dp;
    }
}
