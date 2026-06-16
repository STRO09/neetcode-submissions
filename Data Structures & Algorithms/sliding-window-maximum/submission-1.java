class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        Queue<Integer> queue = new PriorityQueue<>((a,b)-> b - a);
        int arrlen = nums.length;
        int[] result = new int[arrlen - k +1];
        int currIdx = 0;

        for(int i=0 ; i < k ; i++) { 
            queue.offer(nums[i]);
        }   

        result[currIdx++] = queue.peek();

        int left = 0; 
        int right = k-1;

        while( right < arrlen -1) { 
            queue.remove(nums[left++]);
            queue.offer(nums[++right]);
            result[currIdx++] = queue.peek();       
        } 

        return result;
    }
}
