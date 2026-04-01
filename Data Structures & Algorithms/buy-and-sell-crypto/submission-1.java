class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;

        int maxdiff = 0;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = prices[0];
        int minleft = prices[0];

        for (int i = 1; i < n; i++) {
            minleft = Math.min(minleft, prices[i]);
            left[i] = minleft;
        }

        right[n - 1] = prices[n - 1];
        int maxright = prices[n - 1];

        for (int j = n - 2; j >= 0; j--) {
            maxright = Math.max(maxright, prices[j]);
            right[j] = maxright;
        }

        for (int i = 0; i < n; i++) {
            maxdiff = Math.max(maxdiff, right[i] - left[i]);
        }

        return maxdiff;
    }
}