class Solution {

    Stack<Integer> stack = new Stack<>();
    int[] result;

    public int[] dailyTemperatures(int[] temperatures) {

        result = new int[temperatures.length];
        
        for(int i =0; i < temperatures.length; i++) { 

            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int popped = stack.peek();
                result[popped] = i - popped;
                stack.pop();
            }
            stack.push(i);
        } 

        while(!stack.isEmpty()) { 
            int popped = stack.peek();
            result[popped] = 0;
            stack.pop(); 
        }

        return result;

    }
}
