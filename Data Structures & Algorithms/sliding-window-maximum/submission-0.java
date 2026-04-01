class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums.length == 0) return new int[0];

        NavigableMap<Integer, Integer> count = new TreeMap<>();
        int[] maxValues = new int[nums.length - k + 1];
        int maxIdx = 0;

        // First window
        for (int i = 0; i < k; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }

        maxValues[maxIdx++] = count.lastKey();

        int left = 0;
        int right = k;

        while (right < nums.length) {

            // Add new element
            count.put(nums[right], count.getOrDefault(nums[right], 0) + 1);

            // Remove old element
            int freq = count.get(nums[left]);
            if (freq == 1) {
                count.remove(nums[left]);
            } else {
                count.put(nums[left], freq - 1);
            }

            maxValues[maxIdx++] = count.lastKey();

            left++;
            right++;
        }

        return maxValues;
    }
}