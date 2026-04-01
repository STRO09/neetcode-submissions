class MinStack {

    Stack<Integer> stack;
    NavigableMap<Integer, Integer> map;

    public MinStack() {
        stack = new Stack<>();
        map = new TreeMap<>();
    }

    public void push(int val) {
        stack.push(val);
        map.put(val, map.getOrDefault(val, 0) + 1);
    }

    public void pop() {
        int val = stack.pop();
        int count = map.get(val);
        if (count == 1) {
            map.remove(val);
        } else {
            map.put(val, count - 1);
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return map.firstKey();
    }
}