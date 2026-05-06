class KthLargest {
    Queue<Integer> queue;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>();
        for(int i=0; i < nums.length; i++) {
            queue.add(nums[i]);
        }
        int size = queue.size();
        for(int i=0 ; i < size -k; i++) queue.poll();
    }

    public int add(int val) {
        queue.add(val);
        if(queue.size() > k ) { 
            queue.poll();
        }
        return queue.peek();

    }
}
