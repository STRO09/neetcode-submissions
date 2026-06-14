class Solution {
    int[] result;
    public int[] topKFrequent(int[] nums, int k) {
        result = new int[k];
        Map<Integer,Integer> counts = new HashMap<>();

        for(int a : nums) { 
            counts.put(a, counts.getOrDefault(a,0)+1);
        }

        Queue<int[]> sorted = new PriorityQueue<>((a,b)-> b[1]-a[1]);
        for(Map.Entry<Integer, Integer> entry : counts.entrySet()) { 
            sorted.offer(new int[]{entry.getKey(), entry.getValue()});
        }
        for(int i=0 ; i< k;i++) { 
            int[] a = sorted.poll();
            result[i] = a[0];
        }
        return result;
    }
}
