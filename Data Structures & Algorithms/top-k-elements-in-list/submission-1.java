class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num,0)+1);
        }
        List<Integer> keys = new ArrayList<>(map.keySet());
        keys.sort((a,b) -> map.get(b) - map.get(a));
        int[] arr = new int[k];
        for(int i= 0 ; i < k ; i++) {
            arr[i] = keys.get(i);
        }
        return arr;
        

    }
}
