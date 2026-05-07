class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for(int stone : stones) { 
            queue.add(stone);
        }

        while(queue.size() > 1) { 
            int x = queue.poll();   
            int y = queue.poll();

            if(y > x ) queue.add(y-x);
            if(x > y ) queue.add(x-y);
        }
        return (queue.size()==0) ? 0 : queue.poll();
        
    }
}
