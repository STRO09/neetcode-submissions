class MinStack {

    int minValue = Integer.MAX_VALUE;
    Stack<State> minstack;

    static class State { 
        int value;
        int minValueTillNow;

        public State(int v, int m) { 
            this.value=v;
            this.minValueTillNow = m;
        }

        public int getValue() { 
            return this.value;
        }
        
        public int getMinValue() { 
            return this.minValueTillNow;
        }
    }

    public MinStack() {
        minstack = new Stack<>();
    }
    
    public void push(int val) {
        this.minValue = Math.min(minValue, val);
        minstack.push(new State(val, minValue));
    }
    
    public void pop() {
        minstack.pop();  
        if(!minstack.isEmpty())
            this.minValue = minstack.peek().getMinValue();
        else 
            this.minValue = Integer.MAX_VALUE;
    }
    
    public int top() {
        return minstack.peek().getValue();  
    }
    
    public int getMin() {
        return minstack.peek().getMinValue();
    }
}
