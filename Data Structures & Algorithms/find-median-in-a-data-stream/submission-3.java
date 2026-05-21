class MedianFinder {
    PriorityQueue<Double> leftqueue;
    PriorityQueue<Double> rightqueue;
    public MedianFinder() {
        this.leftqueue = new PriorityQueue<Double>(Collections.reverseOrder());
        this.rightqueue = new PriorityQueue<Double>();
    }

    public void addNum(int num) {
        if(leftqueue.isEmpty()) 
            leftqueue.add(Double.valueOf(num));
        else if(rightqueue.isEmpty())  {
            if(leftqueue.peek() > num) leftqueue.add(Double.valueOf(num));
            else rightqueue.add(Double.valueOf(num)); 
        }
           
        else if(leftqueue.peek() < num) { 
            rightqueue.add(Double.valueOf(num)); 
        }
        else 
            leftqueue.add(Double.valueOf(num));


        while( (leftqueue.size() - rightqueue.size()) > 1 ) {
            rightqueue.add(leftqueue.poll());
        }

        while( (rightqueue.size() - leftqueue.size()) > 1 ) {
            leftqueue.add(rightqueue.poll());
        }


    }

    public double findMedian() {
        if(leftqueue.size() > rightqueue.size()) { 
            return leftqueue.peek();
        }
        else if( rightqueue.size() > leftqueue.size() ) { 
            return rightqueue.peek();
        }
        else return (leftqueue.peek() + rightqueue.peek())/2;
    }
}
