class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> queue = new PriorityQueue<>( 
            (a,b) -> {
                int distA = a[0] *a[0] + a[1]*a[1];
                int distB = b[0] *b[0] + b[1]*b[1];

                return distB - distA;
            }
        );

        for(int i=0 ; i < points.length;i++) { 
            queue.add(points[i]);
            if(queue.size() > k) {
                queue.poll();
            }
        }

        int result[][] = new int[queue.size()][2];

        for(int i=0; i < result.length ; i++) { 
            result[i] = queue.poll();
        }

        return result;
    }
}
